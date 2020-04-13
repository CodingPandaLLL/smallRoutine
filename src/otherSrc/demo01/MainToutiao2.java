package demo01;

import java.util.Scanner;

/**
 * 题目：
	定义两个字符串变量：s和m，再定义两种操作， 
	第一种操作：
	m = s; 
	s = s + s; 
	第二种操作：
	s = s + m; 
	假设s, m初始化如下：
	s = "a"; 
	m = s; 
	求最小的操作步骤数，可以将s拼接到长度等于n
	
	输入描述：
	一个整数n，表明我们需要得到s字符长度，0<n<10000
	输出描述：
	一个整数，表明总共操作次数
	
	样例
	in:
	6
	out:
	3
 * @author zj
 *
 */
public class MainToutiao2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 3){
			System.out.println(2);
			return;
		}else if(n % 2 == 1){
			System.out.println(n-1);
			return;
		}
		int len = 1;
		String[] a = new String[2];
		a[0] = "a";
		a[1] = a[0];
		int result = cal(a, n, 1, 0);
		System.out.println(result);
	}
	
	public static int cal(String[] a, int n, int len, int c){
		if(len == n){
			return c;
		}else{
			String[] tmp = new String[2];
			tmp[0] = a[0];
			tmp[1] = a[1];
			fun1(tmp);
			int c1 = cal(tmp, n, tmp[0].length(), c++);
			String[] tmp2 = new String[2];
			tmp2[0] = a[0];
			tmp2[1] = a[1];
			fun2(tmp2);
			int c2 = cal(tmp2, n, tmp2[0].length(), c++);
			return Math.min(c1, c2);
		}
	}
	
	public static void fun1(String[] a){
		a[1] = a[0];
		a[0] = a[0] + a[0];
	}
	
	public static void fun2(String[] a){
		a[0] = a[0] + a[1];
	}
}
