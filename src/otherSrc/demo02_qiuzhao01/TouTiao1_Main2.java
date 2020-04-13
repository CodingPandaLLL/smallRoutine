package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TouTiao1_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		String[] mStr = new String[m];
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int max = 0;
		for(int i = 0; i < m; i++){
			mStr[i] = sc.next();
			String[] arr = mStr[i].split(";");
			for(int j = 0; j < arr.length; j++){
				int x = Integer.parseInt(arr[j].split(",")[0]);
				int y = Integer.parseInt(arr[j].split(",")[1]);
				max = Math.max(max, x);
				max = Math.max(max, y);
				list.add(x);
				map.put(x, y);
			}
		}
		
		int[] f = new int[max];
		for(int i = 0; i < list.size(); i++){
			int key = list.get(i);
			for(int j = key; j < map.get(key); j++){
				f[j] = 1;
			}
		}
		int start = 0,end = 0;
		boolean flag = false;
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for(int i = 0; i < max; i++){
			if(f[i] == 1 && flag == false){
				start = i;
				flag = true;
			}else if(f[i] == 0 && flag == true){
				end = i-1;
				map1.put(start, end);
				flag = false;
			}
		}
		
	}
}
