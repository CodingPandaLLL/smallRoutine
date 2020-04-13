package demo01;

import java.util.Scanner;

public class ZiJieMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int k = 0; k < N; k++){
			 String s = sc.nextLine();
				int n = Integer.parseInt(s.split(" ")[0]);
				int m = Integer.parseInt(s.split(" ")[1]);
				int[] am = new int[m];
				for(int i = 0; i < m; i++){
					am[i] = Integer.parseInt(s.split(" ")[i+2]);
				}
			int[] an = new int[n];	//这n个人的状态,淘汰了就置-1
			for(int i = 0; i < n; i++){
				an[i] = 0;
			}
			
			int curN = 0;
			int curM = 0;
			for(int i = 0; i < n-1; i++){
				int indexM = am[curM];
				while(indexM > 0){
					indexM--;
					while(an[curN] == -1){
						curN = (curN+1)%n;
					}
					curN = (curN+1)%n;
				}
				while(an[curN] == -1){
					curN = (curN+1)%n;
				}
				
				curN = (curN-1 + n)%n;
				an[curN] = -1;
				curN = (curN+1)%n;
				curM = (curM+1)%m;
			}
			for(int i = 0; i < n; i++){
				if(an[i] == 0){
					System.out.println(i);
					break;
				}
			}
		}
	}
}
