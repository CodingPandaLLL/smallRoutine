package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class TuJia_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sqrtN = (int)Math.sqrt(n);
		for(int i = sqrtN-1; i < n;i++){
			long left = i*1l*(i+1);
			long right = (i+1)*1l*(i+2);
			if(left == 2*n){
				System.out.println(i);
				break;
			}else if(left < 2*n && right >= 2*n){
				System.out.println(i+1);
				break;
			}
		}
	}
}
