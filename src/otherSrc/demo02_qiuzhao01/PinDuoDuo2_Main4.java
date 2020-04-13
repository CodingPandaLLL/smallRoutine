package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * AC
 * 思路：
 * 		将输入的字符串竖向分割成l个字符数组，每次就是在这l个数组中各选择一个字符，然后组成一个长度为l的字符串。
 * 		1. 将字符串数组竖向分割
 * 		2. 将分割后的l行n列字符数组每一行都按字典序排序
 * 		3. 然后按全排列的思想，每次从第cur行中选择一个字符保存到tmp[cur]的位置，然后递归去放下一个cur+1位置的字符
 * 		4. 当cur == l时，说明找到一个字符串，判断是否包含在输入字符串数组内（用Map），不包含则说明找到（由于有排序，第一个找到的必定是字典序最小的）
 * 		5. 如果包含在输入字符串数组里，继续在cur位置放c[cur]字符行的下一个字符继续尝试
 * 		6. 如果尝试完了都没找到就说明不存在
 * @author lllzj
 *
 */
public class PinDuoDuo2_Main4 {
	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		String[] s = new String[n];
		for(int i = 0; i < n; i++){
			s[i] = sc.next();
			map.put(s[i], 0);
		}
		char[][] c = new char[l][n];
		for(int i = 0; i < l; i++){
			for(int j = 0; j < n; j++){
				c[i][j] = s[j].charAt(i);
			}
			sort(c[i], 0, n-1);
		}
		char[] tmp = new char[l];
		if(find(c, l, n, tmp, 0)){
			String result = String.valueOf(tmp);
			System.out.println(result);
		}else{
			System.out.println("-");
		}
	}
	
	public static boolean find(char[][] c, int l, int n, char[] tmp, int cur){
		if(cur == l){
			if(map.containsKey(String.valueOf(tmp))){
				return false;
			}else{
				return true;
			}
		}else{
			for(int i = 0; i < n; i++){
				tmp[cur] = c[cur][i];
				if(find(c, l, n, tmp, cur+1)){
					return true;
				}
			}
			return false;
		}
	}
	
	public static void sort(char[] c, int start, int end){
		int i = start, j = end;
		char tmp;
		if(start < end){
			tmp = c[start];	
			while(i != j){
				while(j > i && c[j] >= tmp){
					j--;
				}
				c[i] = c[j];
				while(i < j && c[i] <= tmp){
					i++;
				}
				c[j] = c[i];
			}
			c[i] = tmp;
			sort(c, start, i-1);
			sort(c, i+1, end);
		}
	}
}
