package demo01;

import java.util.Scanner;

public class ZuiChangZiChuan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next().toLowerCase();
		if(s.length() == 0){
            System.out.println("NULL");
            return;
        }
		int start = 0;	//子串起始位置
		int end = 0;	//子串末尾
		int max = 0;	//max = end - start + 1;长度
		for(int i = 0; i < s.length(); i++){
			for(int j = i + 1; j < s.length(); j++){
				String tmp = s.substring(0,i) + s.substring(j+1);
				if(isChongFu(s.substring(i, j+1), tmp)){
					if(max < (j-i+1)){
						start = i;
						end = j;
						max = j - i + 1;
					}
				}
			}
		}
		if(max == 0){
			System.out.println("NULL");
		}else{
			System.out.println(s.substring(start, end+1));
		}
	}
	
	public static boolean isChongFu(String sub, String s){
		return s.contains(sub);
	} 
}
