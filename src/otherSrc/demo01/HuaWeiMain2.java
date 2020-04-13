package demo01;

import java.util.Scanner;

public class HuaWeiMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		
		int[][] d = new int[n][n];	//d[i][j]表示从第i个数跳到第j个数最少跳跃次数
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				int min = d[i][j-1] + 1;
				for(int k = 2;k <= j; k++){		//找出从i到j-1与i到j-k中跳数最少的，然后+1就是i到j最小的
					if(k <= a[j-k]){		//其中k要小于第j-k个数的最大跳跃长度，才能一次调到j处
						if(min > d[i][j-k] + 1){
							min = d[i][j-k] + 1;
						}
					}
				}
				d[i][j] = min;
			}
		}
		System.out.println(d[0][n-1]);
	}
}
