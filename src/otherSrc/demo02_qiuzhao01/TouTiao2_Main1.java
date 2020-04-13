package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TouTiao2_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	//总人数
		Map<Integer, List<Integer>> map = new HashMap<>();	//每个人对应一个关系list
		for(int i = 0; i < n; i++){
			List<Integer> l = new ArrayList<>();
			while(true){
				int tmp = sc.nextInt();
				if(tmp == 0){
					break;
				}else{
					l.add(tmp);
				}
			}
			map.put(i+1, l);
		}
		
		int m = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			int[] f = new int[n+1];
			int result = findM(map, n, f, i+1);
			m = Math.min(result, m);
		}
		System.out.println(m);
	}
	
	public static int findM(Map<Integer, List<Integer>> map, int n, int[] f, int cur){
		List<Integer> list = map.get(cur);
		if(list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				f[list.get(i)] = 1;
				findM(map, n, f, list.get(i));
			}
		}
		int result = 1;
		for(int i = 0; i < n; i++){
			if(f[i+1] == 0){
				result++;
			}
			findM(map, n, f, i+1);
		}
		return result;
	}
}
