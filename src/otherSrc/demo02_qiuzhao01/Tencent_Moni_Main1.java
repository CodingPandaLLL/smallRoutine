package demo02_qiuzhao01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Tencent_Moni_Main1 {

	private static int x;
	private static int y;
	private static List<Integer> l = new LinkedList<>();
	private static List<List<Integer>> rl = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int a = sc.nextInt();
		x = sc.nextInt();
		int b = sc.nextInt();
		y = sc.nextInt();
		int[] arr = new int[x+y];		//是所有长度的集合，然后在这个集合里选出若干个组成歌单
		int tmp = 0;
		for(int i = 0; i < x; i++){
			arr[tmp] = a;
			tmp++;
		}
		for(int i = 0; i < y; i++){
			arr[tmp] = b;
			tmp++;
		}
		int[] f = new int[x+y];		//f[i]表示第i位是否已选
		int result = findWays(arr, f, k, 0, 0);
		System.out.println(result);
	}
	
	public static int findWays(int[] arr, int[] f, int k, int start, int cur){
		int result = 0;
		for(int i = start; i < arr.length; i++){
			f[i] = 1;
			cur = cur + arr[i];
			if(cur == k){
				if(check(arr, f)){
					result = (result+1)%1000000007;
					System.out.println("----" + result);
				}
			}
			result = (result + findWays(arr, f, k, start+1, cur))%1000000007;
			System.out.println(result);
			cur = cur - arr[i];
			f[i] = 0;
		}
		return result;
	}
	
	public static boolean check(int[] arr, int[] f){
		l = new LinkedList<>();
		for(int i = 0; i < x; i++){
			if(f[i] == 1){
				l.add(arr[i]);
			}else{
				l.add(-1);
			}
		}
		for(int i = x; i < x+y; i++){
			if(f[i] == 1){
				l.add(arr[i]);
			}else{
				l.add(-1);
			}
		}
		if(rl.contains(l)){
			return false;
		}else{
			rl.add(l);
			return true;
		}
	}
}
