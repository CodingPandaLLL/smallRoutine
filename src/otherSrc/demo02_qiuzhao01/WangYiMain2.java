package demo02_qiuzhao01;

import java.util.Scanner;

public class WangYiMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] index = new int[n];	//记录每堆水果的初始数
		index[0] = 0;
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			if(i == 0){
				continue;
			}
			index[i] = index[i-1] + a[i-1];
		}
		int m = sc.nextInt();
		int[] q = new int[m];
		for(int i = 0; i < m; i++){
			q[i] = sc.nextInt();
		}
		
		for(int i = 0; i < m; i++){
			int result = calAppleIndex(n, index, q[i]);
			System.out.println(result);
		}
	}
	
	public static int calAppleIndex(int n, int[] index, int q){
		int start = 0;
		int end = n-1;
		while(start <= end){
			int mid = (start + end) / 2;
			if(mid-1>0 && index[mid-1] < q && index[mid] > q){
				return mid;
			}else if(mid + 1 < n && index[mid] < q && index[mid+1] > q){
				return mid+1;
			}else if(mid -1 > 0 && index[mid-1] > q){
				end = mid - 1;
			}else{
				start = mid + 1;
			}
		}
//		for(int i = 0; i < n; i++){
//			if(q <= index[i]){
//				return i;
//			}
//		}
		
		return n;
	}
}
