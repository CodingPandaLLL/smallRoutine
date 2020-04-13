package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao1_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String MNStr = sc.next();
		int M = Integer.parseInt(MNStr.split(",")[0]);
		int N = Integer.parseInt(MNStr.split(",")[1]);
		int[][] f = new int[M][N];
		for(int i = 0; i < M; i++){
			String tmp = sc.next();
			String[] tmpArr = tmp.split(",");
			for(int j = 0; j < N; j++){
				f[i][j] = Integer.parseInt(tmpArr[j]);
			}
		}
		
		
	}
}
