package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 50%
 * @author lllzj
 *
 */
public class XunLei_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] num = new int[7];
		int result = 0;
		if(a + b < 0){
			int allSum = 0;
			int i = 0, j = 6;
			while(i != j){
				num[j] = b;
				int sum = b;
				while(sum < 0 && i != j){
					num[i] = a;
					sum += a;
					i++;
				}
				if(i != j){
					j--;
					num[j] = b;
					sum += b;
				}
				allSum += sum;
			}
			result = 2*allSum + num[0] + num[1] + num[2];
		}else if(a + b == 0){
			result = a;	//b*2 + a*3
		}else{
			int allSum = 0;
			int i = 0, j = 6;
			while(i != j){
				num[j] = b;
				int sum = b;
				while(sum*(-1) <= a && i != j){
					j--;
					num[j] = b;
					sum += b;
				}
				if(i != j){
					num[i] = a;
					i++;
					sum += a;
				}
				allSum += sum;
			}
			result = 2*allSum + num[0] + num[1] + num[2];
		}
		System.out.println(result);
	}
}
