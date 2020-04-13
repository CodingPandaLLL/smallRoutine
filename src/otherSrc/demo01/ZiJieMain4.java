package demo01;

import java.util.Scanner;

public class ZiJieMain4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String q = sc.next();
		String doc = sc.next();
		char[] c = q.toCharArray();
		int len = c.length;
		int[] index = new int[len];
		boolean flag = true;
		for(int i = 0; i < len; i++){
			int t = doc.indexOf(c[i]);
			if(t == -1){
				flag = false;
				break;
			}else{
				index[i] = t;
			}
		}
		if(!flag){
			System.out.println(0);
		}else{
			int min = len;
			for(int i = 1; i < len; i++){
				if(min < index[i] - index[i-1]){
					min = index[i] - index[i-1];
				}
			}
			System.out.println(100-min);
		}
	}
}
