package demo01;

import java.util.Scanner;

public class TouTiaoMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int q = sc.nextInt();
		for(int i = 0; i < q; i++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int count = 0;
			for(int j = 0; j <s.length(); j++){
				switch(s.charAt(j)){
				case 'u':
					x  = x - 1;
					break;
				case 'd':
					x = x + 1;
					break;
				case 'l':
					y = y - 1;
					break;
				case 'r':
					y = y + 1;
					break;
				}
				count ++;
				if(x < 1 || x > n || y < 1 || y > m){
					break;
				}
			}
			System.out.println(count);
		}
	}
	
}
