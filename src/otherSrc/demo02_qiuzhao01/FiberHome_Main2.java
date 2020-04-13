package demo02_qiuzhao01;

import java.util.Scanner;
/**
 * AC
 * @author lllzj
 *
 */
public class FiberHome_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			long min = 0;
			long max = 0;
			if(n % m == 0){
				int c = n / m;
				min = calNum(c) * m;
				max = calNum(n - (m-1));
			}else{
				int c = n / m;
				int d = n % m;
				min = calNum(c) * (m-d) + calNum(c+1)*d;
				max = calNum(n - (m-1));
			}
			System.out.println(min + " " + max);
		}
	}
	
	public static long calNum(int n){
		return (n*1l * (n-1)) / 2;
	}
}
