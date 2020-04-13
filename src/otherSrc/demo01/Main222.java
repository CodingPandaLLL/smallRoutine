package demo01;

import java.util.Scanner;

public class Main222 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			int m = Integer.parseInt(s.split(" ")[0]);
			int n = Integer.parseInt(s.split(" ")[1]);
			boolean flag = false;
			for(int i = m; i <= n; i++){
				int tmp = i;
				int sum = 0;
				while(tmp != 0){
					sum += Math.pow((tmp%10), 3);
					tmp  = tmp/10;
//					System.out.println(sum + "--" + tmp);
				}
				if(sum == i){
					flag = true;
					System.out.print(i + " ");
				}
			}
			if(!flag){
				System.out.println("no");
			}else{
				System.out.println();
			}
		}
	}
}
