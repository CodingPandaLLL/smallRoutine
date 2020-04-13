package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.Scanner;

public class Accelink_Main {
	public static ArrayList<String> result = new ArrayList<String>();
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		moveHanoi(n, "A", "B", "C");
		System.out.println(count);
		for(String s : result){
			System.out.println(s);
		}
	}
	
	/**
	 * 将n个圆盘，从a通过b移动到c
	 * @param n
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void moveHanoi(int n, String a, String b, String c){
		if(n == 1){
			String s = n + " from " + a + " to " + c;
			result.add(s);
			count++;
		}else{
			moveHanoi(n-1, a, c, b);
			String s = n + " from " + a + " to " + c;
			result.add(s);
			count++;
			moveHanoi(n-1, b, a, c);
		}
	}
}
