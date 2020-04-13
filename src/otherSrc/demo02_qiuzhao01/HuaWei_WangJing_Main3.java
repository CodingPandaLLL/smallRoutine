package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuaWei_WangJing_Main3 {

	public static void main(String[] args) {
		String result = "none";
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String customType = sc.next();
		String[] strArray = str.trim().split(";");
		if(strArray.length < 1){
			System.out.println(result);
			return;
		}
		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < strArray.length; i++){
			String[] tmp = strArray[i].trim().split(" ");
			if(tmp.length != 3 || !tmp[0].equals("typedef")){
				System.out.println(result);
				return;
			}
			map.put(tmp[2], tmp[1]);
//			System.out.println(tmp[2] + "---" + tmp[1]);
		}
		
		
		
		if(map.containsKey(customType)){
			result = searchType(map, customType);
		}
		System.out.println(result);
	}
	
	public static String searchType(Map<String, String> map, String customType){
		String result = "";
		if(map.containsKey(customType)){
			String value = map.get(customType);
			if(value.contains("*")){
				String nextKey = value.substring(0, value.indexOf("*"));
				result = searchType(map, nextKey);
				for(int i = value.indexOf("*"); i < value.length(); i++){
					result += " *";
				}
//				System.out.println("1-" + result);
			}else{
				result = searchType(map, value);
//				System.out.println("2-" + result);
			}
		}else{
			result = customType;
//			System.out.println("3-" + result);
		}
		return result;
	}
}
