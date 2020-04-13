package demo01;

import java.util.Scanner;

public class XieChengMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		
		int i = -1, j = -1;	//i指向0元素，j指向非0元素
		for(int k = 0;k < n; k++){
			if(a[k] == 0){
				i = k;
				break;
			}
		}
		if(i == -1){
			i = n;
		}
		for(int k = i;k < n; k++){
			if(a[k] != 0){
				j = k;
				break;
			}
		}
		if(j == -1){
			j = n;
		}
		while(i < n && j < n){
			a[i] = a[j];
			a[j] = 0;
			while(a[i] != 0){
				i++;
				if(i >= n){
					break;
				}
			}
			while(a[j] == 0){
				j++;
				if(j >= n){
					break;
				}
			}
		}
		
		for(int m = 0; m < n; m++){
			System.out.println(a[m]);
		}
	}
}
