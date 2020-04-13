package demo01;

import java.util.Scanner;

public class TencentMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(); // 歌单总长度
		int a = sc.nextInt(); // 第一种歌的长度
		int x = sc.nextInt(); // 第一种歌的数量
		int b = sc.nextInt(); // 第二种歌的长度
		int y = sc.nextInt(); // 第二种歌的数量

		long result = 0;
		int[][] dp = new int[x][y];	//dp[i][j]表示i个第一种歌j个第二种歌的长度
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				dp[i][j] = i * a + j * b;
				if (dp[i][j] == k) {	//i个a加j个b=k，求x个中取i个的组合乘以y个去j个的组合数
					result = (func2(x, i) * func2(y, j)) % 1000000007;
				}
			}
		}
		System.out.println(result);
	}

	/**
	 * 求n的阶乘
	 * @param n
	 * @return
	 */
	private static long func1(int n) {
		long sum = 1;
		while (n > 0) {
			sum = sum * n;
			n--;
		}
		return sum;
	}
	
	/**
	 * 求组合数C(n, m)
	 * n! / (m! * (n - m)!)
	 * @param n
	 * @param m
	 * @return
	 */
	public static long func2(int n, int m) {
		return func1(n) / (func1(m) * func1(n-m));
    }
}
