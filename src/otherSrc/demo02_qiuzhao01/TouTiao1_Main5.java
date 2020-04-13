package demo02_qiuzhao01;

import java.util.Scanner;

public class TouTiao1_Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] s = new int[n];
		int[] t = new int[n];
		for(int i = 0; i < n; i++){
			s[i] = sc.nextInt();
			t[i] = sc.nextInt();
		}
		
		int[] d = new int[n];
		int[] f = new int[m];
		int result = cal(d, f, n, 0, 0, s, t);
		System.out.println(result);
	}
	
	public static int cal(int[] d, int[] f, int n, int current, int count, int[] s, int[] t){
		if(current == n){
			return count+1;
		}
		int max = 0;
		d[current] = 0;
		max = cal(d, f, n, current+1, count, s, t);
		d[current] = 1;
		int[] f1 = f;
		for(int i = s[current]+1; i < t[current]; i++){
			if(f1[i] == 0){
				f1[i] = 1;
			}else{
				return max;
			}
		}
		max = Math.max(max, cal(d, f1, n, current+1, count+1, s, t));
		return max;
	}
}
