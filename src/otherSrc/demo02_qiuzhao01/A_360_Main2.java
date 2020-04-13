package demo02_qiuzhao01;

import java.util.Scanner;

public class A_360_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for(int t = 0; t < q; t++){
			int k = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			int maxCount = 0;
			int max = 0;
			for(int i = l; i <= r; i++){
				int tmp = calNum(k, i);
				if(maxCount < tmp){
					maxCount = tmp;
					max = i;
				}
			}
			System.out.println(max);
		}
	}
	
	public static int calNum(int k, int n){
		int result = 0;
		while(n != 0){
			int t = n % k;
			if(t == k-1){
				result ++;
			}
			n /= k;
		}
		return result;
	}
}
