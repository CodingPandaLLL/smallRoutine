package demo01;

import java.util.Scanner;

public class HuiWenNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {//注意while处理多个case
            int n = sc.nextInt();
            if(n == 0)
            	break;
            int count = 0;
            for(int i = 1; i <= n; i++){
            	if(isHuiWen(i)){
            		count++;
            	}
            }
            System.out.println(count);
        }
	}
	
	public static boolean isHuiWen(int n){
		String s = String.valueOf(n);
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) != s.charAt(s.length()-1-i)){
				return false;
			}
		}
		return true;
	}
}
