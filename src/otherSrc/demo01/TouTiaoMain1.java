package demo01;

import java.util.Scanner;

public class TouTiaoMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int k = 0; k < N; k++){
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = sc.nextInt();
			}
			
			if(n == 1){
				System.out.println(0);
			}else{
				int max = a[n-1] - a[0];
				int min = a[1] - a[0];
				for(int i = min; i <= max; i++){
					boolean flag = true;
					for(int j = 0; j < n && (a[j]+i) <= a[n-1]; j++){
						if(!binSearch(a, n, a[j] + i)){
							flag = false;
							break;
						}
					}
					if(flag){
						System.out.println(i);
						break;
					}
				}
			}
		}
	}
	
	public static boolean binSearch(int[] a, int n, int key){
		int low = 0;
		int high = n - 1;
		int mid;
		while(low <= high){
			mid = (low + high) / 2;
			if(a[mid] == key){
				return true;
			}else if(a[mid] > key){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return false;
	}
}
