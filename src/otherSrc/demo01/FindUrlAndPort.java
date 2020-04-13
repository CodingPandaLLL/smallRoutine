package demo01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FindUrlAndPort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = sc.next();
		String regex = "http?://\\w+\\.\\w+\\.\\w+:\\d{4}/";
		Pattern pattern = Pattern.compile(regex);
		if(pattern.matcher(url).matches()){
			int s1 = 0;	//host开始位置
			int end1= 0;	//host结束位置
			int s2 =0;
			int end2 = 0;
			for(int i = 0; i < url.length(); i++){
				if(url.charAt(i) == '/' && (i + 1) < url.length() && url.charAt(i+1) == '/'){
					s1 = i + 2;
				}else if(url.charAt(i) == ':' && url.charAt(i+1) != '/'){
					end1 = i - 1;
					s2 = i + 1;
				}else if(url.charAt(i) == '/' && url.charAt(i-1) != ':' && url.charAt(i-1) != '/'){
					end2 = i - 1;
					break;
				}
			}
			String host = url.substring(s1, end1 + 1);
			String port = url.substring(s2, end2 + 1);
			System.out.println(host + "," + port);
		}else{
			System.out.println(-1);
		}
	}
}
