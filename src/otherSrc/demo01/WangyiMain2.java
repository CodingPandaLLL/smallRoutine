package demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WangyiMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for(int i = 1; i <= n; i++){
        	for(int j = 1; j <= n; j++){
        		if(i % j >= k){
        			List<Integer> l = new ArrayList<>();
        			l.add(i);
        			l.add(j);
        			if(!result.contains(l)){
        				result.add(l);
        				count ++;
//        				System.out.println(i + "," + j);
        			}
        		}
        	}
        }
        System.out.println(count);
	}
}
