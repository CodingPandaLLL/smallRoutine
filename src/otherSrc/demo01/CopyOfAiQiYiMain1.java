package demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyOfAiQiYiMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			int n = s.length();
			if(n == 1){
				System.out.println(s);
			}else{
				List<Integer> l = new ArrayList<Integer>();
				fun(l, s, 0);
				for(int i = 0; i < l.size(); i++){
					System.out.print(s.charAt(l.get(i)));
				}
			}
		}
	}
	
	public static void fun(List<Integer> l, String s, int start){
		if(start > s.length()-1)
			return;
		char c = s.charAt(start);
		int index = start;
		for(int i = start+1; i < s.length(); i++){
			if((s.charAt(i) - c) > 0){
				c = s.charAt(i);
				index = i;
			}
		}
		l.add(index);
		fun(l, s, index+1);
	}
}
