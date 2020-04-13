package demo02_qiuzhao01;

import java.util.Scanner;

public class WangYiYouDao_Main2 {

	public static void main(String[] args) {
		//分析：最小肯定都是0，最大肯定是一个有人的一个空的的情况
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int space = n-k;
			if(k <= space){
				if(k - 1 >= 0){
					System.out.println("0 " + (k-1));
				}else{
					System.out.println("0 0");					
				}
			}else{
				System.out.println("0 " + space);
			}
		}
	}
}
