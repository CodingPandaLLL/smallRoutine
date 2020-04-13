package demo01;

import java.util.Scanner;

public class HuaWeiMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			
			int[] a = new int[63];
			for(int i = 0; i < s.length(); i++){	//将大小写字母以及数字映射到1-62空间里
				char c = s.charAt(i);
				if(c >= 97 && c <= 122){	//a-z
					a[c-60] ++;
				}else if(c >= 65 && c <= 90){	//A-Z
					a[c-54] ++;
				}else if(c >= 48 && c <= 57){	//0-9
					a[c-47] ++;
				}
			}
			String r = "";
			boolean flag = true;
			while(flag){
				flag = false;
				for(int j = 0; j < 62; j++){
					if(a[j] > 0){
						r  += toChar(j);
						a[j]--;
						if(a[j] > 0){
							flag = true;
						}
					}
				}
			}
			System.out.println(r);
		}
	}
	
	/**
	 * 根据映射的区间返回原字符
	 * @param n
	 * @return
	 */
	public static char toChar(int n){
		if(n >= 1 && n <= 10){
			return (char)(n+47);
		}else if(n >= 11 && n <= 36){
			return (char)(n+54);
		}else if(n >= 37 && n <= 62){
			return (char)(n+60);
		}else{
			return ' ';
		}
	}
}
