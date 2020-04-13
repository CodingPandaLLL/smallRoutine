package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao2_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			int n = sc.nextInt();
			String[] s = new String[n];
			for(int j = 0; j < n; j++){
				s[j] = sc.next();
			}
			boolean flag = hasDouble(s, n);
			if(flag){
				System.out.println("Yeah");
			}else{
				System.out.println("Sad");
			}
		}
	}
	
	public static boolean hasDouble(String[] s, int n){
		boolean result = false;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(isDouble(s[i], s[j])){
					result = true;
					break;
				}
			}
			if(result){
				break;
			}
		}
		return result;
	}
	
	public static boolean isDouble(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		for(int i = 0; i < s1.length(); i++){
			String s3 = s1.substring(i);
			for(int j = 0; j <= i-1; j++){
				s3 += s1.charAt(j);
			}
//			System.out.println(s2 + "--" + s3);
			if(s2.equals(s3)){
				return true;
			}
			String s4 = "";
			for(int j = s1.length()-1; j >= 0; j--){
				s4 += s3.charAt(j);
			}
			if(s2.equals(s4)){
				return true;
			}
		}
		return false;
	}
}
