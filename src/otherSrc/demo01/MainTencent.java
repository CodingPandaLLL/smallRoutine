package demo01;

import java.util.Scanner;

public class MainTencent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
        	int[] x = new int[4];
        	int[] y = new int[4];
        	for(int j = 0; j < 4; j++){
        		x[j] = sc.nextInt();
        	}
        	for(int k = 0; k < 4; k++){
        		y[k] = sc.nextInt();
        	}
        	if(isSquare(x,y)){
        		System.out.println("Yes");
        	}else{
        		System.out.println("No");
        	}
        } 
	}
	
	public static boolean isSquare(int[] x, int[] y){
		double[] a = new double[6];
		a[0] = getSqrt(x[0], y[0],x[1],y[1]);
		a[1] = getSqrt(x[1], y[1],x[2],y[2]);
		a[2] = getSqrt(x[2], y[2],x[3],y[3]);
		a[3] = getSqrt(x[3], y[3],x[0],y[0]);
		a[4] = getSqrt(x[1], y[1],x[3],y[3]);
		a[5] = getSqrt(x[0], y[0],x[2],y[2]);
		//判断四条边相等，并有一个直角则为正方形
		for(int i = 0; i < 6; i++){
			
		}
		return false;
		
	}
	
	public static double getSqrt(int x1,int y1,int x2, int y2){  
	    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));  
	}  
  
}
