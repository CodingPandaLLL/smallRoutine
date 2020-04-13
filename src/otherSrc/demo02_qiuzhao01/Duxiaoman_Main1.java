package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 18%
 * @author lllzj
 *
 */
public class Duxiaoman_Main1 {
	
	public static boolean isA = true;
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			isA = true;
			count = 0;
			boolean f = findWinner(a, b, n);
			if(count >= 3){
				System.out.println("A&B");
				return;
			}
			if(isA){
				System.out.println("A");
			}else{
				System.out.println("B");
			}
		}
	}
	
	public static boolean findWinner(int a, int b, int n){
		count++;
		if(a <= b){
			isA = !isA;
			if(calWays(a+1, b) >= n){
				return true;
			}
			return findWinner(a+1, b, n);
		}else{
			if(calWays(a+1, b) >= n){
				return true;
			}
			boolean f = findWinner(a+1, b, n);
			if(!f){
				if(calWays(a, b+1) >= n){
					return true;
				}
				f = findWinner(a, b+1, n);
			}
			return f;
		}
	}
	
	public static int calWays(int a, int b){
		int sumA = 1;
		int tmpA = a;
		while(tmpA >= (a-b+1)){
			sumA *= tmpA;
//			System.out.println(sumA + " -- " + tmpA);
			tmpA--;
		}
//		int sumB = 1;
//		while(b != 0){
//			sumB *= b;
//			b--;
//		}
//		System.out.println(sumA + ", " + sumB + " == " + sumA/sumB);
		return sumA;
	}
}
