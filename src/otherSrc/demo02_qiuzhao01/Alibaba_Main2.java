package demo02_qiuzhao01;

import java.util.Scanner;

public class Alibaba_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		String s1 = sc.next();
		int x0 = Integer.parseInt(s1.split(",")[0]);
		int y0 = Integer.parseInt(s1.split(",")[1]);
		String s2 = sc.next();
		String[] strArr = s2.split(",");
		int n = strArr.length/2;
		int[] x = new int[n];
		int[] y = new int[n];
		int k = 0;
		for(int i = 0; i < n; i++){
			x[i] = Integer.parseInt(strArr[k++]);
			y[i] = Integer.parseInt(strArr[k++]);
		}
		
		//在多边形内部的话则该点与相邻俩点的角度之和为360度
		double[] degrees = new double[n];
		for(int i = 0; i < n-1; i++){
			degrees[i] = calDegree(x[i], y[i], x[i+1], y[i+1], x0, y0);
		}
		degrees[n-1] = calDegree(x[n-1], y[n-1], x[0], y[0], x0, y0);
		double sum = 0;
		for(int i = 0; i < n; i++){
			sum += degrees[i];
		}
		if(sum == 360){
			System.out.println("yes,0");
		}else{
			//否则计算到达的最小距离
			//找出距离该点最近的一点
			int minX = x[0];
			int minY = y[0];
			int minIndex = 0;
			double minD =  Math.abs(minY - y0)/Math.abs(minX - x0)*1.0;
			for(int i = 1; i < n; i++){
				double tmpD = Math.abs(y[i] - y0)/Math.abs(x[i] - x0)*1.0;
				if(tmpD < minD){
					minD = tmpD;
					minX = x[i];
					minY = y[i];
					minIndex = i;
				}
			}
			//计算该点到距离最近点的距离，以及到距离最近的点相邻两条边的距离中的最短的
			int resultD = calMin(x, y, x0, y0, minIndex);
			System.out.println("no," + resultD);
		}
	}
	
	public static int calMin(int[] x, int[] y, int x0, int y0, int minIndex){
		int pointD = Math.abs(y[minIndex] - y0)/Math.abs(x[minIndex] - x0);
//		int lineD1 = calHigh(x0, y0, x[minIndex], y[minIndex], x[minIndex+1==x.length?0:minIndex+1], y[minIndex+1==x.length?0:minIndex+1]);
//		int lineD2 = calHigh(x0, y0, x[minIndex], y[minIndex], x[minIndex-1==x.length?0:minIndex-1], y[minIndex-1==x.length?0:minIndex-1]);
		//返回最小
		return 0;
	}
	
	/**
	 * 求<acb
	 * @param ax
	 * @param ay
	 * @param bx
	 * @param by
	 * @param cx
	 * @param cy
	 * @return
	 */
	public static double calDegree(int ax, int ay, int bx, int by, int cx, int cy){
		double a = Math.abs(cy - by)/Math.abs(cx - bx)*1.0;
		double b = Math.abs(ay - cy)/Math.abs(ax - cx)*1.0;
		double c = Math.abs(ay - by)/Math.abs(ax - bx)*1.0;
		double C = Math.acos((a*a + b*b - c*c)/(a*b*2.0));
		C = Math.toDegrees(C);
		return C;
	}
}
