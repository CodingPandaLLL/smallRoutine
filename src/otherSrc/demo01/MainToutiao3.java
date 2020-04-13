package demo01;

import java.util.Scanner;
import java.util.Stack;

public class MainToutiao3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack stack1 = new Stack();		//数字栈
		Stack stack2 = new Stack();		//符号栈
		int result = 0;
		for(int i = 0; i < n; i++){
			String s = sc.next();
			char[] c = s.toCharArray();
			for(int j = 0; j < s.length(); j++){
				if(c[j] >= '0' && c[j] <= '9'){
					stack1.push(c[j]);
				}else if(c[j] != '*'){
					stack2.push(c[j]);
				}else if(c[j] == '*'){
					if(!stack2.isEmpty()){
						int a = (char) stack1.pop() - '0';
						int b = (char) stack1.pop() - '0';
						result += a*b;
					}else{
						stack2.push(c[j]);
					}
				}else if(c[j] == '+'){
					if(!stack2.isEmpty() && (char)stack2.peek() != '*'){
						int a = (char) stack1.pop() - '0';
						int b = (char) stack1.pop() - '0';
						result += a+b;
					}else{
						stack2.push(c[j]);
					}
				}else if(c[j] == '-'){
					if(!stack2.isEmpty() && (char)stack2.peek() != '*'){
						int a = (char) stack1.pop() - '0';
						int b = (char) stack1.pop() - '0';
						result += a-b;
					}else{
						stack2.push(c[j]);
					}
				}
			}
			
		}
		while(!stack1.isEmpty() || !stack2.isEmpty()){
			int nextc = (char)stack2.pop();
			if(nextc == '+'){
				int a = (char) stack1.pop() - '0';
				int b = (char) stack1.pop() - '0';
				result += a+b;
			}else if(nextc == '-'){
				int a = (char) stack1.pop();
				int b = (char) stack1.pop();
				result += a-b;
			}
		}
		System.out.println(result);
	}
	
}
