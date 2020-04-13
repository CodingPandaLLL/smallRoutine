package demo02_qiuzhao01;

import java.util.Scanner;

public class WangYiMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		int[] t = new int[n];
		for(int i = 0; i < n; i++){
			t[i] = sc.nextInt();
		}
		
		int result = calMax(n, k, a, t);
		System.out.println(result);
	}
	
	public static int calMax(int n, int k, int[] a, int[] t){
		int result = 0;
		int weakIndex = -1;
		int max = 0;
		for(int i = 0; i < n; i++){
			if(t[i] == 0){
				int tmpSum = 0;
				for(int j = i; j < Math.min(n, i+k); j++){
					if(t[j] == 0){
						tmpSum += a[j];
					}
				}
				if(max < tmpSum){
					weakIndex = i;
					max = tmpSum;
				}
			}
		}
		if(weakIndex != -1){
			for(int i = weakIndex; i < Math.min(n, weakIndex+k); i++){
				t[i] = 1;
			}
			for(int i = 0; i < n; i++){
				if(t[i] == 1){
					result += a[i];
				}else if(i >= weakIndex && i < weakIndex+k){
					result += a[i];
				}
			}
		}else{
			for(int i = 0; i < n; i++){
				if(t[i] == 1){
					result += a[i];
				}
			}
		}
		return result;
	}
}
