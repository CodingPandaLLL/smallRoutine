package demo01;

import java.util.Scanner;

public class TouTiaoMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int m = sc.nextInt();
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		boolean[] f2 = new boolean[n2];
		for(int i = 0; i < n1; i++){
			a1[i] = sc.nextInt();
		}
		for(int i = 0; i < n2; i++){
			a2[i] = sc.nextInt();
			f2[i] = false;	//false表示没选该种纪念币
		}
		
		long result = calNum(a1, a2, f2, 0, 0, 0, m);
		System.out.println(result);
	}
	
	public static long calNum(int[] a1, int[] a2, boolean[] f2, int s1, int s2, long count, int m){
		long result = count;
		for(int i = s1; i < a1.length; i++){
			for(int j = 1; j*a1[i] < m; j++){
				if(m - j*a1[i] == 0){
					result ++;
					return result;
				}
				result += calNum(a1, a2, f2, s1+1, s2, count, m - j*a1[i]);
			}
		}
		for(int i = s2; i < a2.length; i++){
			if(!f2[i] && a2[i] < m){
				if(m - a2[i] == 0){
					result ++;
					return result;
				}
				f2[i] = true;
				result += calNum(a1, a2, f2, s1, s2 + 1, count, m-a2[i]);
			}
		}
		return result%1000000007;
	}
	
}
