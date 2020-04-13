package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TouTiao3_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			int j = i;
			map.clear();
			while(j < s.length()){
				if(map.containsKey(s.charAt(j))){
					break;
				}else{
					map.put(s.charAt(j), 1);
				}
				j++;
			}
			max = Math.max(max, j-i);
		}
		System.out.println(max);
	}
}
