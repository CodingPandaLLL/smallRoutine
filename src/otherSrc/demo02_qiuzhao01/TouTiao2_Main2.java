package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao2_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] d = new long[n];
		for(int i = 0; i < n; i++){
			d[i] = (long) (Math.pow(10, i+1)%1000000007);
			if(i-2 >= 0){
				d[i] = (d[i] + d[i-2])%1000000007;
				for(int j = 0; j < i; j++){
					if(i - j > 1){
						d[i] = (d[i] + d[j] * d[i-j-1] * 2)%1000000007;
					}
				}
			}
		}
		System.out.println(d[n-1]%100000007);
	}
}
