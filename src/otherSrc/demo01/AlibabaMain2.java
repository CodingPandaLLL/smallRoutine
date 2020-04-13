package demo01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AlibabaMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		String tmp;
		for(int i = 0; i < m; i++){
			tmp = sc.next();
			int num1 = Integer.parseInt(tmp.split(",")[0]);
			int num2 = Integer.parseInt(tmp.split(",")[1]);
			map.put(num1, num2);
			map.put(num2, num1);
		}
		
		int[] num = new int[2*n];
		int[] f = new int[2*n];		//代表编号为i的上班情况，0代表未选，1上班，-1不上班
		for(int i = 0; i < 2 * n; i++){
			num[i] = i;
			f[i] = 0;
		}
		boolean[] hasOne = new boolean[n];
		for(int i = 0; i < n; i++){
			hasOne[i] = false;
		}
		
		for(int i = 0; i < 2 * n; i++){
			if(f[i] != -1){
				f[i] = 1;
				if(map.containsKey(f[i])){
					f[map.get(f[i])] = -1;
				}
				hasOne[i/2] = true;
			}else{
				if(f[i] % 2 == 0 && hasOne[i/2] == false){	//如果这一组都没有人
					f[i] = 1;
					int t = f[i];
					while(map.containsKey(t)){		//更新与之有敌对关系的
						f[map.get(t)] = f[t] * -1;
						t = map.get(t);
					}
				}
			}
		}
		
		boolean hasway = true;
		for(int i =0; i < n; i++){
			if(hasOne[i] == false){
				hasway = false;
				break;
			}
		}
		
		if(hasway){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
}
