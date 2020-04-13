package demo02_qiuzhao01;

import java.util.Scanner;

public class A_360_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		boolean[] f = new boolean[n];
		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			f[i] = false;
		}
		long result = 0;
		for(int i = 0; i < n; i++){
			result +=calSum(x, f, i, n);
		}
		System.out.println(result);
	}
	
	public static long calSum(int[] x, boolean[] f, int cur, int n){
		long result = 0;
		f[cur] = true;
		for(int i = 0; i < n; i++){
			if(i != cur && !f[i]){
				result += Math.abs(x[cur] - x[i]);
				f[i] = true;
				result += calSum(x, f, i, n);
				f[i] = false;
			}
		}
		f[cur] = false;
		return result % 1000000007;
	}
}
