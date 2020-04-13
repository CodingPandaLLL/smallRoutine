package demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JingDongMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] c = s.toCharArray();
		int n = c.length;
		
		List<String> resultList = new ArrayList<>();
		String s1 = "";
		int count = calHuiWen(c, s1, resultList, 0, 0);
		System.out.println(count);
	}
	
	public static int calHuiWen(char[] c,String s, List<String> resultList, int start, int count){
		int result = count;
		for(int i = start; i < c.length; i++){
			s = s + c[i];
			if(isHuiWen(s)){
				String tmp = "";
				for(int j = 0; j < start - s.length(); j++){
					tmp  = tmp + c[j];
				}
				if(!resultList.contains(tmp)){
					resultList.add(tmp);
					result ++;
				}
			}
			result += calHuiWen(c,s, resultList,start + 1, result );
			s = s.substring(0, s.length()-1);
		}
		return result;
	}
	
	/**
	 * 判断字符串是否是回文
	 * @param s
	 * @return
	 */
	public static boolean isHuiWen(String s){
		int len = s.length();
		boolean b = true;
		if(len == 0)
			return false;	//空串不是回文串
		
		for(int i = 0, j = len-1; i < j; i++, j--){
			if(s.charAt(i) != s.charAt(j)){
				b = false;
				break;
			}
		}
		return b;
	}
}



/*for(int j = 0; j < n; j++){
	for(int i= 0; i <= n-j; i++){
		String tmp = s.substring(j, j+i);
		if(isHuiWen(tmp)){
			String tmp2 = s.substring(0, j) + s.substring(j+i, n);
			if(!resultList.contains(tmp)){
				resultList.add(tmp2);
				count++;
			}
		}
	}
}*/