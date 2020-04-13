package demo02_qiuzhao01;

import java.util.Scanner;

public class Tencent_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a % b == 0 && c != 0){
				System.out.println("NO");
				continue;
			}else if(a % b == 0 && c == 0){
				System.out.println("YES");
				continue;
			}
			int d = a % b;
			if(d % 2 == 0){
				if(c % 2 == 0){
					if(b % d == 0){
						if(d > c || c % d != 0){
							System.out.println("NO");
							continue;
						}
					}
					System.out.println("YES");
					continue;
				}else{
					System.out.println("NO");
					continue;
				}
			}else{
				if(b % 2 == 0){
					System.out.println("YES");
					continue;
				}else{
					if(b % d == 0 && (c % d != 0 || d % c != 0)){
						System.out.println("NO");
						continue;
					}else{
						System.out.println("YES");
						continue;
					}
				}
			}
		}
	}
}

/**
 * 牛客别人直接暴力AC代码
 * 作者：yuan123
链接：https://www.nowcoder.com/discuss/110616
来源：牛客网

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0;i < t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            boolean flag = false;
            for(int j = 1;j <= 100*a;j++){
                if(j*a%b==c){
                    flag = true;
                    break;
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
 * **/
