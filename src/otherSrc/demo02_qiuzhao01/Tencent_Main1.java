package demo02_qiuzhao01;

import java.util.Scanner;

public class Tencent_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//计算从n+1到m的最小公倍数
		int a = n+1, b = n+1;
		int tmpMinPower = minPower(a, b);
		int m = n+1;
		for(int i = n+1; i < 2*(n+1); i++){
			a = tmpMinPower;
			b = i;
			tmpMinPower = minPower(a, b);
			//计算从(n+1)/2到n+1的最小公倍数
			int ta = (i+1)/2, tb = (i+1)/2, tMin = (i+1)/2;
			for(int j = (n+1)/2; j < i+1; j++){
				ta = tMin;
				tb = j;
				tMin = minPower(ta, tb);
			}
			if(tmpMinPower == tMin){
//				System.out.println(tmpMinPower + " ---" + tMin);
				m = i;
				break;
			}
		}
		
		System.out.println(m);
	}
	
	/**
	 * 求两个数的最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int maxDivisor(int a, int b){
		int mod = a % b;
		while(mod != 0){
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}
	
	/**
	 * 求最小公倍数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int minPower(int a, int b){
		//最小公倍数 * 最大公约数 = a * b
		int max_divisor = maxDivisor(a, b);
		int result = (a * b) / max_divisor;
		return result;
	}
}
