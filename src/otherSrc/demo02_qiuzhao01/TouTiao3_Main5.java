package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 50%
 * @author lllzj
 *
 */
public class TouTiao3_Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			map.put(a, b);
		}
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++){
			findCount(n, map, countMap, i+1);
		}
		int count = 0;
		for(int i = 1; i < n+1; i++){
			if(map.containsKey(i) && map.get(i) == n-1){
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void findCount(int n, Map<Integer, Integer> map, Map<Integer,Integer> countMap, int cur){
		Map<Integer, Integer> tmpMap = new HashMap<Integer, Integer>();
		if(map.containsKey(cur)){
			if(countMap.containsKey(map.get(cur))){
				countMap.put(map.get(cur), countMap.get(map.get(cur))+1);
			}else{
				countMap.put(map.get(cur), 1);
			}
			tmpMap.put(map.get(cur), 1);
			int tmp = map.get(cur);
			while(map.containsKey(tmp)){
				tmp = map.get(tmp);
				if(tmpMap.containsKey(tmp)){
					break;
				}else{
					tmpMap.put(tmp, 1);
					if(countMap.containsKey(tmp)){
						countMap.put(tmp, countMap.get(tmp)+1);
					}else{
						countMap.put(tmp, 1);
					}
				}
			}
		}
	}
}
