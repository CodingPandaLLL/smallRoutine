package a_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 表达式求值
 * （输入一个只包含+ - * / 正整数 圆括号的表达式，转换为后缀表达式，计算出结果）
 * @author lllzj
 * @date 2018/8/28
 */
public class ComputeExpressionValue {
	
	private static Map<Character, Integer> lmap = new HashMap<>();
	private static Map<Character, Integer> rmap = new HashMap<>();

	public static void main(String[] args) {
		initPriorityMap();
		String exp = "(56-20)/(4+2)";
		String postexp = transfer(exp);
		System.out.println(exp + "的后缀表达式为：" + postexp);
		int result = computeValue(postexp);
		System.out.println(exp + "=" + result);
	}
	
	/**
	 * 将中缀表达式转化为后缀表达式——利用栈
	 * @param exp
	 * @return
	 */
	public static String transfer(String exp){
		Stack<Character> st = new Stack<>();
		st.push('=');
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < exp.length(); i++){
			if(exp.charAt(i) >= '0' && exp.charAt(i) <= '9'){
				while(exp.charAt(i) >= '0' && exp.charAt(i) <= '9'){
					sb.append(exp.charAt(i));
					i++;
				}
				sb.append('#');
			}
			char l = st.peek();
			char r = exp.charAt(i);
			if(lmap.get(l) < rmap.get(r)){	//左运算符优先级小于右运算符，右入栈
				st.push(r);
			}else if(lmap.get(1) == rmap.get(r)){	//左运算符为(，右为)，将(前所有运算符出栈到后缀表达式，再出栈(
				st.pop();
			}else{	//左运算符优先级大于右运算符，左运算符出栈到后缀表达式，然后右运算符入栈
				if(r == ')'){
					while(lmap.get(st.peek()) > rmap.get(r)){
						sb.append(st.pop());
					}
					st.pop();
				}else{
					sb.append(st.pop());
					st.push(r);
				}
			}
		}
		while(!st.isEmpty() && st.peek() != '='){
			sb.append(st.pop());
		}
		return sb.toString();
	}
	
	/**
	 * 后缀表达式求值
	 * @param postexp
	 * @return
	 */
	public static int computeValue(String postexp){
		Stack<Integer> nStack = new Stack<>();
		for(int i = 0; i < postexp.length(); i++){
			if(postexp.charAt(i) >= '0' && postexp.charAt(i) <= '9'){
				StringBuilder sb = new StringBuilder();
				while(postexp.charAt(i) >= '0' && postexp.charAt(i) <= '9'){
					sb.append(postexp.charAt(i));
					i++;
				}
				nStack.push(Integer.parseInt(sb.toString()));
			}else if(postexp.charAt(i) == '+'){
				int n2 = nStack.pop();
				int n1 = nStack.pop();
				nStack.push(n1+n2);
				System.out.println(n1 + "+" + n2 + "=" + (n1+n2));
			}else if(postexp.charAt(i) == '-'){
				int n2 = nStack.pop();
				int n1 = nStack.pop();
				nStack.push(n1-n2);				
				System.out.println(n1 + "-" + n2 + "=" + (n1-n2));
			}else if(postexp.charAt(i) == '*'){
				int n2 = nStack.pop();
				int n1 = nStack.pop();
				nStack.push(n1*n2);				
				System.out.println(n1 + "*" + n2 + "=" + (n1*n2));
			}else if(postexp.charAt(i) == '/'){
				int n2 = nStack.pop();
				int n1 = nStack.pop();
				nStack.push(n1/n2);				
				System.out.println(n1 + "/" + n2 + "=" + (n1/n2));
			}
		}
		return nStack.pop();
	}
	
	
	/**
	 * 初始化运算符优先级
	 */
	public static void initPriorityMap(){
		lmap.put('=', 0);
		lmap.put('(', 1);
		lmap.put('+', 3);
		lmap.put('-', 3);
		lmap.put('*', 5);
		lmap.put('/', 5);
		lmap.put(')', 6);
		rmap.put('=', 0);
		rmap.put('(', 6);
		rmap.put('+', 2);
		rmap.put('-', 2);
		rmap.put('*', 4);
		rmap.put('/', 4);
		rmap.put(')', 1);
	}
}
