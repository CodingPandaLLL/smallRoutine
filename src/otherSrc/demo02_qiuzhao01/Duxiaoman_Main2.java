package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 73%
 * @author lllzj
 *
 */
public class Duxiaoman_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		int[] result = new int[n-1];
		for(int i = 1; i < n; i++){
			int count = 0;
			for(int j = 0; j < i; j++){
				for(int k = i; k < n; k++){
					if(a[j] != a[k]){
						count++;
					}
				}
			}
			result[i-1] = count;
		}
		for(int i = 0; i < n-2; i++){
			System.out.print(result[i] + " ");
		}
		System.out.print(result[n-2]);
	}
}
