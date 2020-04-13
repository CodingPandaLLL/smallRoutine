package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 9%
 * @author lllzj
 *
 */
public class MeiTuan_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int t = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		if(k > n){
            System.out.println(0);
        }else{
            int result = find(a, n, k, t);
            System.out.println(result);
        }
	}
	
	public static int find(int[] a, int n, int k, int t){
		int[][] d = new int[n][n];
		int result = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(j - i + 1 == k){
					boolean f = check(a, i, j, t);
					if(f){
						result++;
					}
				}
			}
		}
		return result;
	}
	
	public static boolean check(int[] a, int l, int r, int t){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = l; i <= r; i++){
			if(map.containsKey(a[i])){
				int c = map.get(a[i])+1;
				if(c >= t){
					return true;
				}else{
					map.put(a[i], c);
				}
			}else{
				if(t == 1){
					return true;
				}else{
					map.put(a[i], 1);
				}
			}
		}
		map.clear();
		return false;
	}
}
