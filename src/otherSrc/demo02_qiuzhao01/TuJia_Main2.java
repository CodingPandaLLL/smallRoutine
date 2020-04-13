package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 0-1背包
 * AC
 * @author lllzj
 *
 */
public class TuJia_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int m = sc.nextInt();
		int[] w = new int[s];
		int[] v = new int[s];
		boolean[] f = new boolean[s];
		for(int i = 0; i < s; i++){
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			f[i] = false;
		}
		
		int result = calBagMaxValue(w, v, m, f, 0);
		System.out.println(result);
	}
	
	public static int calBagMaxValue(int[] w, int[] v, int m, boolean[] f, int curValue){
		int maxValue = 0;
		for(int i = 0; i < w.length; i++){
			if(f[i] == false){
				if(m - w[i] >= 0){
					f[i] =  true;
					int r = calBagMaxValue(w, v, m-w[i], f, curValue + v[i]);
//					System.out.println("maxValue= max(" + maxValue + ", " + r + ")");
					maxValue = Math.max(maxValue, r);
					f[i] = false;
				}else{	//当前物品还没被装进去，但是装不进去了，那么就考虑最大价值为当前背包价值
					maxValue = Math.max(maxValue, curValue);
				}
			}
		}
		return maxValue;
	}
}
