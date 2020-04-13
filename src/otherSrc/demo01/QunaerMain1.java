package demo01;

import java.util.Scanner;

/**
 * 
hot
doh got dot god tod dog lot log
 * @author zj
 *
 */
public class QunaerMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		String dictoryString = sc.nextLine();
		String[] dic = dictoryString.split(" ");
		String reword = "";
		for(int i = word.length()-1; i >= 0 ; i--){
			reword += word.charAt(i);
		}
//		System.out.println(reword);
		int result = changeLength(word, reword, dic, 1);
		
		System.out.println(result);
		
	}
	
	public static int changeLength(String word, String reword, String[] dic, int len){
		int result = 0;
		for(int i = 0; i < dic.length; i++){
			if(canChange(word, dic[i])){
				if(dic[i].equals(reword)){
					result = len;
					break;
				}else if(canChange(reword, dic[i])){
					result = len + 1;
					break;
				}else{
					result = changeLength(dic[i], reword, dic, len+1);
					break;
				}
			}
			if(result > 99){
				return 99;
			}
		}
		
		return result;
	} 
	
	/**
	 * 判断两个字符串是否仅有一位字符不同
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean canChange(String a, String b){
		int count = 0;
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) != b.charAt(i)){
				count++;
			}
		}
		if(count != 1){
//			System.out.println(a + "-" + b + "-false");
			return false;
		}else{
//			System.out.println(a + "-" + b + "-true");
			return true;
		}
	}
}
