package demo01;

import java.util.Scanner;
import java.util.Stack;

public class JingDongMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			String s = sc.next();
			char[] c = s.toCharArray();
			boolean flag = false;
			for(int i = 0; i < c.length; i++){
				for(int j = i+1; j < c.length; j++){
					char tmp = c[i];
					c[i] = c[j];
					c[j] = tmp;
					if(isMatch(c)){
						flag = true;
						break;
					}
					tmp = c[i];
					c[i] = c[j];
					c[j] = tmp;
				}
				if(flag)
					break;
			}
//			System.out.println(c);
			if(flag){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
	
	/**
	 * 判断括号数组是否匹配
	 * @param c
	 * @return
	 */
	public static boolean isMatch(char[] c){
		int n = c.length;
		boolean flag = true;
		Stack st = new Stack();
		int i = 0; 
		while(i < n){
			if(c[i] == '('){
				st.push(c[i]);
			}else if(c[i] == ')'){
				if(!st.isEmpty()){
					char tmp = (char) st.pop();
					if(tmp != '('){
						flag = false;
						break;
					}
				}else{
					flag = false;
					break;
				}
			}
			i++;
		}
		return flag;
	}
}

