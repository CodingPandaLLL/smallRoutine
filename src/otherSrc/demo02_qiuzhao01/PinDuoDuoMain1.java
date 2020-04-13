package demo02_qiuzhao01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PinDuoDuoMain1 {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		String[] persons = {"Alice", "Bob", "Cathy", "Dave"};
//		Queue<String> q = new LinkedList<String>();
//		q.offer("Alice");
//		q.offer("Bob");
//		q.offer("Cathy");
//		q.offer("Dave");
//		String current = null;
//		while(N > 0){
//			N--;
//			current = q.poll();
//			q.offer(current);
//			q.offer(current);
//		}
//		System.out.println(current);
//	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] persons = {"Alice", "Bob", "Cathy", "Dave"};
		int p = 2;
		while((Math.pow(2, p)-4) < N){
			p++;
		}
		double tmp = N - Math.pow(2, p-1)+4;	//这里是减去前面的和，剩下的再来算应该的谁
//		int c = (int) ((tmp / 4)/Math.pow(2, p-3));
//		System.out.println(p);
		String current = null;
		if(tmp-Math.pow(2, p-3) <= 0){
			current = persons[0];
		}else if(tmp-2*Math.pow(2, p-3) <= 0){
			current = persons[1];
		}else if(tmp-3*Math.pow(2, p-3) <= 0){
			current = persons[2];
		}else if(tmp-4*Math.pow(2, p-3) <= 0){
			current = persons[3];
		}
		System.out.println(current);
	}
}
