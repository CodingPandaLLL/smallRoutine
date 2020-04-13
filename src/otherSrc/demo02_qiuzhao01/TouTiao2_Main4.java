package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao2_Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
		}
		int[] a = new int[n*t];
		int k = 0;
		for(int i = 0; i < t; i++){
			for(int j = 0; j < n; j++){
				a[k] = arr[j];
				k++;
			}
		}
		int[] d = new int[n*t];
		d[0] = 1;
		int m = 0;
		for(int i = 1; i < n*t; i++){
			int max = 0;
			for(int j = 0; j < i; j++){
				if(a[j] <= a[i]){
					max = Math.max(d[j], max);
				}
			}
			d[i] = max+1;
			m = Math.max(m, d[i]);
		}
		System.out.println(m);
	}
}
