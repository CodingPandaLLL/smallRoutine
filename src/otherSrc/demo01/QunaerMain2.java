package demo01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求n个数中是否存在i个数的和刚好为m
 * 存在则输出perfect
 * 否则输出good
 * @author zj
 *
 */
public class QunaerMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//n家包机商
		int m = sc.nextInt();	//m个座位
		int[] a = new int[n];	//n家包机商对座位的诉求
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		
		Arrays.sort(a);
		boolean flag = sum(a, m, 0);
		
		if(flag){
			System.out.println("perfect");
		}else{
			System.out.println("good");
		}
	}
	
	/**
	 * 将排序后的数组a递归求和等于m
	 * @param a
	 * @param m
	 * @param start	每次从数组的第几个开始计算
	 * @return
	 */
	public static boolean sum(int[] a, int m, int start){
		for(int i = start; i < a.length; i++){
			if(m - a[i] > 0){
				boolean tmp = sum(a, m-a[i], i+1);
				if(tmp){
//					System.out.println(a[i] + "-" + start);
					return true;
				}
			}else if(m - a[i] == 0){
//				System.out.println("true " + a[i] + "-" + start);
				return true;
			}else{	//由于数组已排序，所以相减小于0就没必要再循环后面的了
//				System.out.println("break " + a[i]);
				break;
			}
		}
		
		return false;
	}
}
