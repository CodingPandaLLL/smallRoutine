package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.Scanner;

public class Alibaba_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		
		//数组长度大于等于3，说明最多拆分n/3个数组
		int d = n/3;
		for(int i = 1; i <= d; i++){	//拆分成i个数组的情况
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			
		}
		
	}
}
