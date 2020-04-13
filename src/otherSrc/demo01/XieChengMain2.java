package demo01;

import java.util.Scanner;

public class XieChengMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String s1[] = s.split(" ");
		int n = s1.length;
		int a[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			a[0][i] = Integer.parseInt(s1[i]);
		}
		for(int i = 1; i < n; i++){
			for(int j = 0; j < n; j++){
				a[i][j] = sc.nextInt();
			}
		}
		
		int b[][] = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				b[j][i] = a[n-1-i][j];
			}
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}
}
