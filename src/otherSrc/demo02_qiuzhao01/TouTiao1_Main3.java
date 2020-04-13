package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao1_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i < n; i++){
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
//		quickSort(x, y, 0, n-1);
		
		int[] d = new int[n];
		int max = 0;
		for(int i = 0; i < n; i++){
			for(int j = i; j < n; j++){
				int sumA = 0, sumAY = 0;
				for(int k = i; k <= j; k++){
					sumA += x[k];
					sumAY += y[k];
					d[k] = 1;
				}
//				System.out.println(sumA + "-" + sumAY);
				max = Math.max(max, calMax(sumA, sumAY, d, x, y));
				for(int k = i; k <= j; k++){
					d[k] = 0;
				}
			}
		}
		System.out.println(max);
		
	}
	
	public static int calMax(int sumA, int sumAY, int[] d, int[] x, int[] y){
		boolean flag = false;
		int max = 0;
		for(int i = 0; i < d.length; i++){
			for(int j = i; j < d.length; j++){
				int sumB = 0;
				int sumBY = 0;
				for(int k = i; k <= j; k++){
					if(d[k] == 0){
						sumB += x[k];
						sumBY += y[k];
					}
					if(sumB == sumA){
						flag = true;
						break;
					}
				}
				if(flag){
					max = Math.max(max, sumAY + sumBY);
					flag = false;
				}
			}
		}
		return max;
	}
	
//	public static void quickSort(int[] a, int[] b, int start, int end){
//		int i = start, j = end;
//		int tmp, tmpb;
//		if(start < end){									
//			tmp = a[start];	
//			tmpb = b[start];
//			while(i != j){						
//				while(j > i && a[j] >= tmp){		
//					j--;
//				}
//				a[i] = a[j];
//				b[i] = b[j];
//				while(i < j && a[i] <= tmp){		
//					i++;
//				}
//				a[j] = a[i];	
//				b[j] = b[i];
//			}
//			a[i] = tmp;			
//			b[i] = tmpb;
//			quickSort(a, b, start, i-1);		
//			quickSort(a, b, i+1, end);		
//		}
//	}
}
