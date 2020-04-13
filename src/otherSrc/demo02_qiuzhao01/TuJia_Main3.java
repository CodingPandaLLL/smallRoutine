package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class TuJia_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			ArrayList<Integer> left = new ArrayList<Integer>();
			left.add(a);
			left.add(b);
			left.add(c);
			boolean f = true;
			int count = 0;
			while(f){
				int size = left.size();
				int tmpCount = 0;
				for(int i = 0; i <size; i++){
					for(int j = i+1; j < size; j++){
						int d = Math.abs(left.get(i) - left.get(j));
						if(!left.contains(d)){
							left.add(d);
							count++;
							tmpCount++;
						}
					}
				}
				if(tmpCount == 0){
					f = false;
				}
			}
			System.out.println(count);
		}
	}
}
