package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 27%
 * @author lllzj
 *
 */
public class JingDong_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] x = new int[m];
			int[] y = new int[m];
			//存每个点相连的点
			Map<Integer, ArrayList<Integer>> relationMap = new HashMap<Integer, ArrayList<Integer>>();
			for(int i = 0; i < m; i++){
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				if(relationMap.containsKey(x[i])){
					ArrayList<Integer> tmp = relationMap.get(x[i]);
					tmp.add(y[i]);
					relationMap.put(x[i], tmp);
				}else{
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(y[i]);
					relationMap.put(x[i], tmp);
				}
				if(relationMap.containsKey(y[i])){
					ArrayList<Integer> tmp = relationMap.get(y[i]);
					tmp.add(x[i]);
					relationMap.put(y[i], tmp);
				}else{
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(x[i]);
					relationMap.put(y[i], tmp);
				}
			}
			//任意两个不同集合内的点之间有边相连->说明只要任意两个点之间没有边相连，它们就一定是一个集合的
			//任意两个同一集合内的点之间没有边，说明只要两个点有边，就不是一个集合
			//遍历一遍相连关系，记录下每个点应该在的组的起始点，有相连关系的点不能在一个组里，若有矛盾就no
			//存每个点相连的点
			Map<Integer, ArrayList<Integer>> noMap = new HashMap<Integer, ArrayList<Integer>>();
			//循环每一个点，构造它们同一个组的点的链表
			for(int i = 1; i < n+1; i++){
				ArrayList<Integer> tmp = new ArrayList<>();
				if(relationMap.containsKey(i)){
					ArrayList<Integer> relationList = relationMap.get(i);
					for(int j = 1; j < n+1; j++){
						if(j != i && !relationList.contains(j)){
							tmp.add(j);
							//检查要跟i一个组的j相连的边是不是都与i相连
							if(relationMap.containsKey(j)){
								ArrayList<Integer> relationJ = relationMap.get(j);
								for(Integer rj : relationJ){
									if(!relationList.contains(rj)){
										System.out.println("No");
										return;
									}
								}
							}else{
								System.out.println("No");
								return;
							}
						}
					}
				}else{		//如果关系map中没有与之相连的，那么其他点都应该跟它一个组
					for(int j = 1; j < n+1; j++){
						if(j != i){
							tmp.add(j);
							//i没有与之相连的，那么其他跟它一个组的也应该没有关联关系
							if(relationMap.containsKey(j)){
								System.out.println("No");
								return;
							}
						}
					}
				}
				if(tmp.size() > 0){
					noMap.put(i, tmp);
				}
			}
			System.out.println("Yes");
		}
	}
}
