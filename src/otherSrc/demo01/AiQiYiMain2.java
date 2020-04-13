package demo01;

import java.util.Scanner;

public class AiQiYiMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int result = calCount(a, b, c);
			System.out.println(result);
		}
	}
	
	public static int calCount(int a, int b, int c){
		if(a == b && b == c)
			return 0;
		int[] num = new int[6];
		num[0] = 1 + calCount(a, b+1, c+1);
		num[1] = 1 + calCount(a+1, b, c+1);
		num[2] = 1 + calCount(a+1, b+1, c);
		num[3] = 1 + calCount(a+2, b, c);
		num[4] = 1 + calCount(a, b+2, c);
		num[5] = 1 + calCount(a, b, c+2);
		int min = num[0];
		for(int i = 1; i < 6; i++){
			if(min > num[i]){
				min = num[i];
			}
		}
		return min;
	}
}
