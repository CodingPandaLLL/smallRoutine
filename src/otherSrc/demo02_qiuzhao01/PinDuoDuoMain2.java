package demo02_qiuzhao01;

import java.util.Scanner;

public class PinDuoDuoMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] arr = new char[M][N];
		for(int i = 0; i < M; i++){
			String s = sc.next();
			arr[i] = s.toCharArray();
		}
		int[][] dp = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = i+1; j < N; j++){
				int c1 = 0, c2 = 0;
				for(int k = 0; k < M; k++){
//					System.out.println(k+"-" + i + "-" + j + "-" + arr.length + "-" + arr[0].length);
					if(arr[k][i] < arr[k][j]){	//i比j高
						c1++;
					}else if(arr[k][i] > arr[k][j]){
						c2++;
					}
				}
				if(c1 > c2){
					dp[i][j] = 1;
					dp[j][i] = -1;
				}else if(c1 < c2){
					dp[i][j] = -1;
					dp[j][i] = 1;
				}
			}
		}
		for(int i = 0; i < N; i++){
			int c = 0;
			for(int j = 0; j < N; j++){
				if(dp[i][j] == 1){
					c++;
				}
			}
			if(c == N-1){
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
