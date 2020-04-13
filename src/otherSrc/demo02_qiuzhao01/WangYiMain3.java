//package demo02_qiuzhao01;
//
//import java.util.Scanner;
//
//public class WangYiMain3 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine();
//		String[] t = s.trim().split(" ");
//		int n = Integer.parseInt(t[0]);
//		int m = Integer.parseInt(t[1]);
//		int k = Integer.parseInt(t[2]);
//		
//		int all = calAll(n, n+m);
//		if(k > all){
//			System.out.println(-1);
//		}
//		int[] f = new int[n+m];
//		findK(n, n+m, k, f);
//		StringBuffer result = new StringBuffer();
//		for(int i = 0; i < n+m; i++){
//			if(f[i] == 0){
//				result.append("z");
//			}else{
//				result.append("a");
//			}
//		}
//		System.out.println(result.toString());
//	}
//	
//	public static int findK(int n, int m, int k, int[] f){
//		int[] a = new int[m];
//		for(int i = 0; i < m; i++){
//			if(f[i] == 0){
//				f[i] = 1;
//			}
//		}
//	}
//	
//	public static int calAll(int n, int m){
//		int r = 1;
//		for(int i = m-n+1; i <= m; i++){
//			r *= i;
//		}
//		for(int i = 1; i <= n; i++){
//			r /= i;
//		}
//		return r;
//	}
//}
