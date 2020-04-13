package demo01;

import java.util.Scanner;

public class TencentMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long sum = 0;
		int g = n/m;	//共几组
		int d =  m*m;	//每组与前面一组的差值，该组符号为正的组与符号为负的组
		if(g%2 == 0){	//如果最后一组符号为正
			sum = g/2 * d;
		}else{			//如果最后一组符号为负
			sum = g/2 * d + (-1*(n-1) - n);
		}
		System.out.println(sum);
	}
}

/*import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		long sum = 0;
		for(int i = 0; i < n; i++){
			a[i] = -1 * (i+1);
			int tmp = i/m;
			if(tmp % 2 == 1){
				a[i] *= -1;
			}
			sum = sum + a[i];
		}
		System.out.println(sum);
	}
}
*/
