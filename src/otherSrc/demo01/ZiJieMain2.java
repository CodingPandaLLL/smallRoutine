package demo01;

import java.util.Scanner;

public class ZiJieMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
            String s1 = sc.nextLine();
            while(s1 == "" || s1.equals(""))
                s1 = sc.nextLine();
			int m = Integer.parseInt(s1.split(" ")[0]);	//前缀字符串库元素个数
			int n = Integer.parseInt(s1.split(" ")[1]);	//要进行前缀查找的元素个数
			String[] sm = new String[m];
			for(int i = 0; i < m; i++){
				sm[i] = sc.next();
	//			System.out.println(sm[i]);
			}
			sc.nextLine();
			String[] sn = new String[n];
			for(int i = 0; i < n; i++){
				sn[i] = sc.next();
	//			System.out.println(sn[i]);
			}
			
			for(int i = 0; i < n; i++){
				boolean flag = false;
				for(int j = 0; j < m; j++){
					int tmp = sn[i].indexOf(sm[j]);
					if(tmp != -1){
						if(tmp == 0){
							System.out.println(1);
							flag = true;
							break;
						}
					}
				}
				if(!flag){
					System.out.println(-1);
				}
			}
//			System.out.println();
		}
	}
}
