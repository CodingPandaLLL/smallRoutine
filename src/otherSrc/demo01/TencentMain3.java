package demo01;

import java.util.Scanner;

public class TencentMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//机器数量
		int m = sc.nextInt();	//任务数量
		int[] z = new int[n];	//每台机器的最大工作时间
		int[] w = new int[n];	//机器等级
		int[] x = new int[m];	//每个任务需要的完成时间
		int[] y = new int[m];	//任务难度等级
		
		int[][] d = new int[m][n];	//d[i][j]表示第i个任务交给第j个机器完成的收益，不能完成则为-1
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(w[j] >= y[i] && z[j] >=x[i]){	//第j个机器能完成第i个任务
					d[i][j] = 200 * x[i] + 3 * y[i];
				}else{
					d[i][j] = -1;		//不能完成
				}
			}
		}
		
		int[] a = new int[m];	//a[i] = 1表示第i个任务已有机器处理，=0表示没有
		int[] b = new int[n];	//b[i] = 1表示第i个机器已被任务占用，=0表示没有
		
		//接下来遍历二维数组d，采用广度优先算法，若d[i][j]的a[i] = 0且b[j] = 0则表示该任务可以交给该机器
		//所得收益可以用于计算
		
		
	}
}
