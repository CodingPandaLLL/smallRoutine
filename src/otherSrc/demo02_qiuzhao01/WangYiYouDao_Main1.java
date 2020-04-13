package demo02_qiuzhao01;

import java.util.Scanner;

public class WangYiYouDao_Main1 {

	public static void main(String[] args) {
		//分析：分为角元素，边元素和中间元素来考虑，只要不是一行或者一列的情况都应该是0
		//一行一列、n行一列和一行n列单独考虑
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 1 && m == 1){
				System.out.println(1);
			}else if(n == 1){
				System.out.println(m-2);
			}else if(m == 1){
				System.out.println(n-2);
			}else{
				System.out.println((n-2)*(m-2));
			}
		}
	}
}
