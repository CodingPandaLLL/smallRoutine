package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 10%
 */
public class TouTiao4_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n];
		Map<Integer, HashMap<String, Integer>> map = new HashMap<Integer,HashMap<String, Integer>>();
		for(int i = 0; i < n; i++){
			s[i] = sc.next();
			for(int j = 0; j < s[i].length(); j++){
				if(map.containsKey(j)){
					HashMap<String, Integer> l = map.get(j);
					if(!l.containsKey(s[i].substring(0, j+1))){
						l.put(s[i].substring(0, j+1), 1);
					}else{
						l.put(s[i].substring(0, j+1), l.get(s[i].substring(0, j+1))+1);
					}
					map.put(j, l);
				}else{
					HashMap<String, Integer> l = new HashMap<String, Integer>();
					l.put(s[i].substring(0, j+1), 1);
					map.put(j, l);
				}
			}
		}
		for(int i = 0; i < n; i++){
			int j = 0;
			for(;j < s[i].length(); j++){
				HashMap<String, Integer> l = map.get(j);
				if(l.get(s[i].substring(0, j+1)) == 1){
					break;
				}
			}
			System.out.println(s[i].substring(0, j+1));
		}
	}
}
