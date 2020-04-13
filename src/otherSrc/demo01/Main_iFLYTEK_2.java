package demo01;

import java.util.Scanner;

public class Main_iFLYTEK_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int a = 0, b = 0;
		for(int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
			if(arr[i] == 1){
				a++;
			}else{
				b++;
			}
		}
		int result = 0;
		if(a >= b){
			result = n*m - b*x - (a-b)*k;
		}else{
			result = n*m - b*x;
		}
		System.out.println(result);
	}
}
