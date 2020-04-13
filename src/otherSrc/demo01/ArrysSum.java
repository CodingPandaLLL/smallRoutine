package demo01;

import java.util.Scanner;

public class ArrysSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			int n = Integer.parseInt(s.split(" ")[0]);
			int m = Integer.parseInt(s.split(" ")[1]);
			double sum = n;
			double d = n;
			for(int i = 1; i < m; i++){
				d = Math.sqrt(d);
				sum += d;
			}
			System.out.printf("%.2f", sum);
		}
	}
}
