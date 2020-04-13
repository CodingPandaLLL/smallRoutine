package demo02_qiuzhao01;

import java.util.Arrays;
import java.util.Scanner;

public class IFLYTEK_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			int n = sc.nextInt();	//总人数
			int x = sc.nextInt();	//平均分
			int[] grade = new int[n];	//每个人的成绩数组
			for(int j = 0; j < n; j++){
				grade[j] = sc.nextInt();
			}
			int result = changeGrade(grade, n, x);
			System.out.println(result);
		}
	}
	
	public static int changeGrade(int[] grade, int n, int x){
		Arrays.sort(grade);
		int[] d = new int[n];	//与平均分的差值数组
		int i = 0;
		for(int k = 0; k < n; k++){
			d[k] = grade[k] - x;
			if(d[k] >= 0 && k > 0){
				i = k-1;
			}
		}
		int j = n-1;
		while(d[j] > 0 && i >= 0){
			if(Math.abs(d[i]) > d[j]){
				d[i] += d[j];
				d[j] = 0;
				j--;
			}else if(Math.abs(d[i]) == d[j]){
				d[i] += d[j];
				d[j] = 0;
				i--;
				j--;
			}else{
				d[j] += d[i];
				d[i] = 0;
				i--;
			}
		}
		if(d[i] == 0){
			return i;
		}else{
			return i+1;
		}
	}
}
