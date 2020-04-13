package demo01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WangyiMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minX = Integer.MAX_VALUE,maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for(int i = 0; i < n; i++){	//左下角横坐标
        	x1[i] = sc.nextInt();
        	if(x1[i] < minX){
        		minX = x1[i];
        	}
        }
        for(int i = 0; i < n; i++){	//左下角纵坐标
        	y1[i] = sc.nextInt();
        	if(y1[i] < minY){
        		minY = y1[i];
        	}
        }
        for(int i = 0; i < n; i++){	//右上角横坐标
        	x2[i] = sc.nextInt();
        	if(x2[i] > maxX){
        		maxX = x2[i];
        	}
        }
        for(int i = 0; i < n; i++){	//右上角纵坐标
        	y2[i] = sc.nextInt();
        	if(y2[i] > maxY){
        		maxY = y2[i];
        	}
        }
        int[][] area = new int[maxY - minY + 1][maxX - minX + 1];	//设二维数组表示平面
//        System.out.println(minX + "," + minY + "--" + maxX + "," + maxY);
        int max = 0;
        for(int i = 0; i < n; i++){
        	for(int j = x1[i]; j < x2[i]; j++){
        		for(int k = y1[i]; k < y2[i]; k++){
        			area[j-minX][k-minY] ++;
        			if(area[j-minX][k-minY] > max){
        				max = area[j][k];
        			}
        		}
        	}
        }
        System.out.println(Math.max(max, 1));
	}
}
