package demo02_qiuzhao01;

import java.util.Scanner;

public class WangYiYouDao_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];	//每层的容量
		int[] cur = new int[n];	//每层的当前体积
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			cur[i] = 0;
		}
		for(int t = 0; t < m; t++){
			int cmdFlag = sc.nextInt();
			if(cmdFlag == 2){
				int x = sc.nextInt();
				int v = sc.nextInt();
				for(int i = x-1; i < n; i++){
					if(cur[i] < a[i]){
						int r = a[i] - cur[i];
						if(r < v){	//剩余容量小于要倒入的体积
							cur[i] = a[i];
							v -= r;
						}else{
							cur[i] += v;
							v = 0;
							break;
						}
					}
				}
			}else if(cmdFlag == 1){
				int k = sc.nextInt();
				System.out.println(cur[k-1]);
			}
		}
	}
}
