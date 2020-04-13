package a_arithmetic_other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lll_HuaWei {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			// 该字符已出现过
			if(map.containsKey(str.charAt(i) + "")){
				// 是连续出现的
				if(i > 0 && str.charAt(i) == str.charAt(i-1)) {
					map.put(str.charAt(i) + "", map.get(str.charAt(i) + "") + 1);
				} else {	// 非连续出现的
					int tmp = 0;
					for (int j = i; j < str.length(); j++) {
						if (str.charAt(j) == str.charAt(i)){
							tmp ++;
						} else {
							break;
						}
					}
					if (map.get(str.charAt(i) + "") < tmp) {
						map.put(str.charAt(i) + "", tmp);
					}
					i += tmp - 1;
				}
			} else {	// 该字符第一次出现
				l.add(str.charAt(i) + "");
				map.put(str.charAt(i) + "", 1);
			}
		}
		// l排个序
		quickSort(l, 0, l.size()-1);
		
		int max = 0;
		String maxStr = "";
		for(int i = 0; i < l.size(); i++) {
			String s = l.get(i);
			if(max < map.get(s)){
				max = map.get(s);
				maxStr = s;
			}
		}
		
		String result = "";
		for(int i = 0; i < max; i++) {
			result += maxStr;
		}
		System.out.println(result);
	}
	
	
	public static void quickSort(List<String> l, int start, int end){
		int i = start, j = end;
		char tmp;
		if(start < end){
			tmp = l.get(start).charAt(0);	
			while(i != j){	
				while(j > i && l.get(j).charAt(0) >= tmp){	
					j--;
				}
				l.set(i, l.get(j));
				while(i < j && l.get(i).charAt(0) <= tmp){	
					i++;
				}
				l.set(j, l.get(i));
			}
			l.set(i, tmp+"");								
			quickSort(l, start, i-1);	
			quickSort(l, i+1, end);		
		}
	}
}
