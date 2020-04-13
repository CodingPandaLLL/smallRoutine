package demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainToutiao4 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			List<Integer> a = new ArrayList<Integer>();
			List<Integer> b = new ArrayList<Integer>();
			for(int i = 0; i < n; i++){
				int tmp = sc.nextInt();
				a.add(tmp);
			}
			for(int i = 0; i < m; i++){
				int tmp = sc.nextInt();
				b.add(tmp);
			}
			
			int result = magic(a, b, 0);
			System.out.println(result);
		}
		
		public static int magic(List<Integer> a, List<Integer> b, int c){
			int result = 0;
			
			for(int i =0; i < a.size(); i++){
				double aA = average(a);
				double aB = average(b);
				b.add(a.get(i));
	            a.remove(i);
	            double aA2 = average(a);
	            double aB2 = average(b);
	            if(aA2 > aA && aB2 > aB){
	            	c++;
	            	result = magic(a, b, c);
	            }
	            
	        }
			
			return result;
		}
		
		public static double average(List<Integer> l){
			double result = 0;
			double sum = 0;
			for(int i = 0; i < l.size(); i++){
				sum += l.get(i);
			}
			result = sum / l.size();
			return result;
		}
		
	}
