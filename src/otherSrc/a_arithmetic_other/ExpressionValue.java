package a_arithmetic_other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 表达式求值：转换为后缀表达式，然后求值
 * 示例：
 * 	输入：(56-20)/(4+2)
 * 	输出：
 * 		56#20#-4#2#+/
 * 		6
 * @author zj
 *
 */
public class ExpressionValue {

	static Map<Character, Integer> lmap = new HashMap<>();
	static Map<Character, Integer> rmap = new HashMap<>();
	
	public static void main(String[] args) {
		initOperatorMap(lmap, rmap);							//初始化左右运算符优先级map
		List<Character> postexp = new ArrayList<Character>();
		Scanner sc = new Scanner(System.in);
		String exp = sc.next();									//输入中缀表达式
		trans(exp, postexp);									//转换为后缀表达式
		System.out.print("后缀表达式为：");						//输出后缀表达式
		printList(postexp);
		float result = compvalue(postexp);						//计算后缀表达式结果
		System.out.println("结果为：" + result);
	}
	
	/**
	 * 计算后缀表达式的值
	 * @param postexp
	 * @return
	 */
	public static float compvalue(List<Character> postexp){
		Stack<Float> st = new Stack<Float>();
		float a,b,c,d;
		int i = 0;
		char tmp;
		while(i < postexp.size()){
			tmp = postexp.get(i);
			switch(tmp){
			case '+':			//加法：出栈两个数字，计算后结果再入栈
				a = st.pop();
				b = st.pop();
				c = a + b;
				st.push(c);
				break;
			case '-':			//减法
				a = st.pop();
				b = st.pop();
				c = b - a;
				st.push(c);
				break;
			case '*':			//乘法
				a = st.pop();
				b = st.pop();
				c = a * b;
				st.push(c);
				break;
			case '/':			//除法
				a = st.pop();
				b = st.pop();
				if(a != 0){
					c = b / a;
					st.push(c);
				}else{
					System.out.println("除0错误！");
					System.exit(0);		//异常退出
				}
				break;
			default:			//处理数字字符
				d = 0;		//将连续的数字字符转换成对应的数值存放到d中
				while(i < postexp.size() && tmp >= '0' && tmp <= '9'){
					d = 10 * d + (tmp-'0');
					i++;					//取下一个字符
					tmp = postexp.get(i);	//tmp直到#时不为数字，刚好#号就会被越过去，因为最后还有个i++
				}
//				System.out.println(d);
				st.push(d);
				break;
			}
			i++;
		}
		return st.peek();
	}
	
	/**
	 * 将表达式转化为后缀表达式
	 * @param exp	String——中缀表达式
	 * @param postexp	List——后缀表达式
	 */
	public static void trans(String exp, List<Character> postexp){
		Stack<Character> opStack = new Stack<>();
		opStack.push('=');
		char tmp;
		for(int i = 0; i < exp.length(); ){
			tmp = exp.charAt(i);
			if(!isOperator(tmp)){	//不是操作符
				while(tmp >= '0' && tmp <= '9'){	//是数字字符
					postexp.add(tmp);
					i++;
					tmp = exp.charAt(i);
				}
				postexp.add('#');
			}else{					//是操作符
				switch(calPriority(opStack.peek(), tmp)){
				case -1:	//栈顶运算符优先级低
					opStack.push(tmp);	//将新遇到的操作符进栈
					i++;				//取下一个字符
					break;
				case 0:		//只有括号满足这种情况
					opStack.pop();		//出栈括号
					i++;				//取下一个字符
					break;
				case 1:		//栈顶运算符优先级高
					postexp.add(opStack.pop());	//将符号栈中符号出栈到后缀表达式中，继续与符号栈中下一个符号比较，所以没有i++
					break;
				}
			}
		}
		//此时运算表达式已经扫描完毕，将符号栈中的字符依次出栈到后缀表达式链表中
		while(!opStack.isEmpty() && opStack.peek() != '='){
			postexp.add(opStack.pop());
		}
	}
	
	/**
	 * 计算运算符的优先级
	 * @param op1	作为左运算符
	 * @param op2	作为右运算符
	 * @return	op1>op2 返回1（左>右，出栈），op1=op2返回-1（左<右，进栈），op1=op2只有括号满足，出栈
	 */
	public static int calPriority(char op1, char op2){
		if(lmap.get(op1) == rmap.get(op2)){
			return 0;
		}else if(lmap.get(op1) < rmap.get(op2)){
			return -1;
		}else{
			return 1;
		}
	}
	
	/**
	 * 判断是否是操作符
	 * （这里认为除数字外只会输入操作符(,),*,/,+,-）
	 * @param ch
	 * @return
	 */
	public static boolean isOperator(char ch){
		if(ch == '(' || ch == ')' || ch == '*' || ch == '/' || ch == '+' || ch == '-')
			return true;
		else
			return false;
	}
	
	/**
	 * 初始化运算符优先级map
	 * 运算符：=,(,*,/,+,-,)
	 * lmap：左运算符优先级map，即运算符作为先出现的运算符时的优先级
	 * rmap：右运算符优先级map，即运算符作为后出现的运算符时的优先级
	 * （左就是即将要入栈的，右就是栈内的，栈底有个=优先级最低）
	 * @param lmap
	 * @param rmap
	 */
	public static void initOperatorMap(Map<Character, Integer> lmap, Map<Character, Integer> rmap){
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
	
	/**
	 * 输出列表内容
	 * @param postexp
	 */
	public static void printList(List<Character> postexp){
		for(int i = 0; i < postexp.size(); i++){
			System.out.print(postexp.get(i));
		}
		System.out.println();
	}
}
