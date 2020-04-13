package demo01;

import java.util.Scanner;

public class AiQiYiMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			int n = s.length();
			if(n == 1){
				System.out.println(s);
			}else{
				int[] dp = new int[n];	//第i个字符的最大子序列长度
				dp[0] = 1;
				int[] pre = new int[n];	//前一个字符的序号
				for(int i = 0; i < n; i++){
					pre[i] = -1;
				}
				for(int i = 1; i < n; i++){
					int max = 1;
					for(int j = 0; j < i; j++){
						if((s.charAt(i) - s.charAt(j) >= 0) && dp[j]+1 > max){
							max = dp[j]+1;
							pre[i] = j;
						}
					}
					dp[i] = max;
				}
				int max = 0,index = 0;
				for(int i = 0; i < n; i++){
					if(dp[i] > max){
						max = dp[i];
						index = i;
					}
				}
//				System.out.println(max + "-" + index);
				String r = "";
				for(int i = index; i >= 0;){
					r = s.charAt(i) + r;
					i = pre[i];
//					System.out.println("pre:" + i);
				}
				System.out.println(r);
			}
		}
	}
}
