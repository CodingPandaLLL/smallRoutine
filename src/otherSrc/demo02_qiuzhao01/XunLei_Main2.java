package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class XunLei_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for(int i = 1; i <= n; i++){
			for(int j = i; j <= n; j++){
				int sumAB = i*i + j*j;
				int c = (int)Math.sqrt(sumAB);
				if(c <= n && c*c == sumAB){
					if(check(i, j, c)){
						System.out.println(i + "," + j + "," + c);
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}
	
	public static boolean check(int a, int b, int c){
		if(checkTwo(a,b) && checkTwo(a, c) && checkTwo(b, c)){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean checkTwo(int a, int b){
		int r = 1;
		for(int i = 1; i < a; i++){
			if(a % i == 0 && b % i == 0){
				r = i;
			}
		}
		if(r == 1){
			return true;
		}else{
			return false;
		}
	}
}
