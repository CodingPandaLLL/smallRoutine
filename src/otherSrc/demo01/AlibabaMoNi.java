package demo01;

import java.util.Scanner;

/**
 * 去除相邻的最大重复子串
 * 示例：
 * 	输入：我说了我没有重复啊没有重复啊没有重复啊，我说没有重复啊
 *  输出：我说了我没有重复啊，我说没有重复啊
 *  （最大重复子串为：没有重复啊，长度为5）
 * @author zj
 *
 */
public class AlibabaMoNi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] str = s.toCharArray();
		char[] tmp = new char[s.length()];
		int len = 0;
		int maxLen = 0;
		String max = "";
		if(s.length() <= 1){
			System.out.println(s);
		}
		tmp[0] = str[0];
		int i,j;
		j = 0;
		//找出最大的重复串
		while(j < str.length){
			tmp[0] = str[j];
			i = 1;
//			j++;
			len = 1;
			if(str[j] <= '9' && str[j] >= '0'){
				j++;
			}else{
				int k = j+1;
				while(k < str.length){
//					System.out.println(new String(tmp));
					if(str[k] == tmp[0] && len > 1){
						int t1 = 0;
						int t2 = k;
						boolean f = true;
						while(t2 < str.length && t1 < len && f){
							if(str[t2] == tmp[t1]){
								t2++;
								t1++;
							}else{
								f = false;
							}
						}
						if(f && t1 == len){
//							System.out.println("llll-" + t1 + "-" + len);
							if(maxLen < len){
								maxLen = len;
								max = new String(tmp).substring(0, len);
							}
							k+=len;
						}else{
							tmp[i] = str[k];
							k++;
							i++;
							len++;
						}
					}else{
						tmp[i] = str[k];
						k++;
						i++;
						len++;
					}
				}
				j++;
			}
		}
		System.out.println("max：" + max + ", "+ new String(tmp) + ", len:" + maxLen + ", " + len);
		if(!max.equals("")){
			//去掉相邻的最大重复串——利用KMP算法
			String ss = s;
			int pre = -1;
			int p = -1;
			int tLen = max.length();
			pre = KMPIndex(ss, max);
			ss = ss.substring(pre+tLen);
			while(KMPIndex(ss, max) != -1){
				p = KMPIndex(ss, max);
				if(p == 0){
					s = s.substring(0, pre+tLen) + s.substring(pre+2*tLen);
				}
				pre = p;
				ss = ss.substring(pre+tLen);
			}
			System.out.println(s);
		}else{
			System.out.println(s);
		}
	}
	
	/**
	 * KMP算法——求子串t在主串s中出现的第一个索引位置
	 * @param s
	 * @param t
	 * @return
	 */
	public static int KMPIndex(String s, String t){
		int[] next = new int[t.length()];
		int i = 0, j = 0;	//i指向主串中要比较的位置，j指向子串中要比较的位置
		getNext(t, next);
		while(i < s.length() && j < t.length()){
			if(j == -1 || s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			}else{				//不相等则j回退，i不变
				j = next[j];
			}
		}
		if(j >= t.length()){
			return (i - t.length());
		}else{
			return -1;
		}
	}
	
	/**
	 * KMP算法中求next数组的算法
	 * @param t
	 * @param next
	 */
	public static void getNext(String t, int[] next){
		int j, k;
		j = 0; k  = -1; next[0] = -1;
		while(j < t.length() - 1){
			if(k == -1 || t.charAt(j) == t.charAt(k)){
				j++;
				k++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
	}
}
