package demo01;

import java.util.Scanner;

/**
 * 
 * @author zj
 *
 */
public class ZiJieMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		boolean isMul = false;
		boolean isYin = false;
		boolean isEnd = false;
		int l = 0;
		int r = 0;
		while(sc.hasNextLine() && !isEnd){
			String curLine = sc.nextLine();
			for(int i = 0; i < curLine.length(); i++){
				if(curLine.charAt(i) == '/'){
					if(isYin){	//在引号中
						
					}else if(isMul){	//是多行注释
						if(curLine.charAt(i-1) == '*' && isMul){
							count++;
							isMul = false;
						}
					}else if(i+1 < curLine.length()){	//是多行注释的起始
						if(curLine.charAt(i+1) == '*'){
							isMul = true;
							i++;
						}else if(curLine.charAt(i+1) == '/'){
							count++;
							break;
						}
					}
				}else if(curLine.charAt(i) == '"' && curLine.charAt(i-1) != '\\'){
					if(isYin){
						isYin = false;
					}else{
						isYin = true;
					}
				}else if(curLine.charAt(i) == '{' && !isYin && !isMul){
					l++;
//					System.out.println(l);
				}else if(curLine.charAt(i) == '}' && !isYin && !isMul){
					r++;
				}
			}
			if(l == r && l != 0){
				isEnd = true;
				break;
			}
		}
		System.out.println(count);
	}
}
