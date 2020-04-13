package demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AiQiYiMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for(int k = 0; k < n; k++){
			l[k] = sc.nextInt();
			r[k] = sc.nextInt();
		}
		
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curlist = new ArrayList<>();
		long result = calNum(n, m, l, r, list,curlist, 0,0);
		System.out.println(result);
	}
	
	public static long calNum(int n, int m, int[] l, int[] r, List<ArrayList<Integer>> list,ArrayList<Integer> curlist,long count, int index){
		if(index >= n)
			return count;
		for(int i = l[index]; i <= r[index] && i <= m; i++){
			if(i == m){
				curlist.add(i);
				if(!list.contains(curlist)){
					count++;
					return count;
				}
			}else{
				curlist.add(i);
				ArrayList<Integer> tmp = new ArrayList<>(curlist);
				long tmpcount = calNum(n, m-i, l, r, list, tmp, count, index+1);
				if(tmpcount != 0){
					count = tmpcount;
				}
				curlist.remove(curlist.size()-1);
			}
		}
		return count;
	}
}
