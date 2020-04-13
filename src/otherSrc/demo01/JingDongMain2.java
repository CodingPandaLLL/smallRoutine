package demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JingDongMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++){
			long n = sc.nextLong();
			List<List<Long>> resultList = new ArrayList<>();
			long[] min = new long[2];
			min[1] = Long.MAX_VALUE;
			min[0] = 0;
			if(calN(n, min)){
				System.out.println(min[0] + " " + min[1]);
			}else{
				System.out.println("No");
			}
		}
	}
	
	public static boolean calN(long n, long[] min){
		boolean flag = false;
		for(long x = 1; x < n; x+=2){
			if(n%x == 0){
				long y = n/x;
				if(y%2 == 0){
					flag = true;
					if(y < min[1]){
						min[0] = x;
						min[1] = y;
					}
				}
			}
		}
		return flag;
	}
}

