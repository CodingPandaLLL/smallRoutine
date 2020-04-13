package demo02_qiuzhao01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
6,3,5,4,6
2,2,6,5,4
10
 * @author lllzj
 *
 */
public class HuaWei_WangJing_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valueStr = sc.next();
		String weightStr = sc.next();
		int bagSize = sc.nextInt();
		String[] valuetmp = valueStr.split(",");
		String[] weighttmp = weightStr.split(",");
		int n = valuetmp.length;
		int[] v = new int[n];
		int[] w = new int[n];
		for(int i = 0; i < n; i++){
			v[i] = Integer.parseInt(valuetmp[i]);
			w[i] = Integer.parseInt(weighttmp[i]);
		}
		//d[i][j]：第i次选择后，所选物品放入一个容量为j的背包中能获得的最大价值
		int[][] d = new int[n+1][bagSize+1];
		d[0][w[0]] = v[0];
		for(int i = w[0]; i<= bagSize; i++){
			d[0][i] = v[0];
		}
		for(int i = 1; i < n; i++){
			for(int j = 1; j <= bagSize; j++){
				if(j >= w[i]){
					d[i][j] = Math.max(d[i-1][j], d[i-1][j-w[i]] + v[i]);
//					System.out.println(i + "--" + j + "----" + d[i][j]);
				}else{
					d[i][j] = d[i-1][j];
				}
			}
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < bagSize+1; j++){
				System.out.println(i + "--" + j + "----" + d[i][j]);
			}
		}
		
		System.out.println(d[n-1][bagSize]);
		
	}
	
	
}
