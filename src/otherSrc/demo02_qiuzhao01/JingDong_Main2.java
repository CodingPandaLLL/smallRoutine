package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class JingDong_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		int count = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(a[j] > a[i] && b[j] > b[i] && c[j] > c[i]){
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
