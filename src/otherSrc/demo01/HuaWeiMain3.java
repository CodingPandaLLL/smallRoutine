package demo01;

import java.util.Scanner;

public class HuaWeiMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int n = a.length();
		int m = b.length();
		
		//用摆算式求解的方式
		int[] c = new int[n + m];	//两数相乘，结果长度肯定小于它俩长度相加
		for(int i = n-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				int num1 = a.charAt(i) - 48;
				int num2 = b.charAt(j) - 48;
				c[i+j+1] += num1 * num2;	//最前面一位留着放最前面的进位
			}
		}
		
		//求c中的进位
		for(int i = c.length-1; i > 0; i--){
			if(c[i] > 9){	//有进位
				int tmp = c[i];
				c[i] = c[i] % 10;	//该位=原来数对10取余
				c[i-1] += tmp / 10;	//将进位加到前一位去
			}
		}
		String result = "";
		int s = 0;
		while(c[s] == 0){
			s++;
		}
		for(int i = s; i < c.length; i++){
			result += String.valueOf(c[i]);
		}
		System.out.println(result);
	}
}
