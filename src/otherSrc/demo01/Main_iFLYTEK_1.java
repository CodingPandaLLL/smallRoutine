package demo01;

import java.util.Scanner;

public class Main_iFLYTEK_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] xyz = new int[3];
		xyz[0] = sc.nextInt();
		xyz[1] = sc.nextInt();
		xyz[2] = sc.nextInt();
		int[][] wz = new int[n][3];
		for(int i = 0; i < n; i++){
			wz[i][0] = sc.nextInt();
			wz[i][1] = sc.nextInt();
			wz[i][2] = sc.nextInt();
		}
		int count = 0;
		for(int j = 0; j < n; j++){
			boolean flag = true;
			if(xyz[0] >= 0){
				if(wz[j][0] < 0 || wz[j][0] > xyz[0]){
					flag = false;
				}
			}else{
				if(wz[j][0] >0 || wz[j][0] < xyz[0]){
					flag = false;
				}
			}
			if(xyz[1] >= 0){
				if(wz[j][1] < 0 || wz[j][1] > xyz[1]){
					flag = false;
				}
			}else{
				if(wz[j][1] >0 || wz[j][1] < xyz[1]){
					flag = false;
				}
			}
			if(xyz[2] >= 0){
				if(wz[j][2] < 0 || wz[j][2] > xyz[2]){
					flag = false;
				}
			}else{
				if(wz[j][2] >0 || wz[j][2] < xyz[2]){
					flag = false;
				}
			}
			if(flag){
				count ++;
			}
		}
		System.out.println(count);
	}
}
