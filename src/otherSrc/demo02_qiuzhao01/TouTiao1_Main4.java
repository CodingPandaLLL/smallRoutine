package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao1_Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		int[] b = new int[n];
		for(int i = 0; i < n; i++){
			b[i] = sc.nextInt();
		}
		
		int c = 0;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(calMax(a, i, j) <= calMin(b, i , j)){
					c++;
				}
			}
		}
		System.out.println(c);
	}
	
	public static int calMax(int[] a, int x, int y){
		int max = 0;
		for(int i = x; i <= y; i++){
			max = Math.max(max,  a[i]);
		}
//		System.out.println("max:" + x + "-" + y + "-"+max);
		return max;
	}
	
	public static int calMin(int[] a, int x, int y){
		int min = Integer.MAX_VALUE;
		for(int i = x; i <= y; i++){
			min = Math.min(min,  a[i]);
		}
//		System.out.println("min:" + x + "-" + y + "-"+min);
		return min;
	}
}
