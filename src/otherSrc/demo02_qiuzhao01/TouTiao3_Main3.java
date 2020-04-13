package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao3_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int result = findCount(s, n-1, 3, 0);
		System.out.println(result);
	}
	
	public static int findCount(String s, int positions, int points, int start){
		int result = 0;
		int maxLen = positions - points +1;
		if(start >= s.length()){
			return 0;
		}
		if(positions == 0 && points > 0){
			return 0;
		}
		if(points == 0){
			String subStr = s.substring(start);
			if(subStr.length() > 1 && subStr.charAt(0) == '0'){
				return 0;
			}
			if(Integer.parseInt(subStr) > 255){
				return 0;
			}
		}
		if(maxLen == 1){
			return 1;
		}else{
			if(s.charAt(start) == '0'){
				result = findCount(s, positions-1, points-1, start+1);
				return result;
			}
			for(int i = start; i < start+maxLen; i++){
				int tmpLen = i - start + 1;
				result += findCount(s, positions-tmpLen, points-1, i+1);
			}
		}
		return result;
	}
}
