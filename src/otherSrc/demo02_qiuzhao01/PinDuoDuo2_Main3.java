package demo02_qiuzhao01;

import java.util.Scanner;

public class PinDuoDuo2_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		double c = a/(b*1.0);
        if(c - a/b*1.0 < 0.000000001){
			System.out.println("0 0");
			return;
		}
		String cStr = String.valueOf(c);
//		System.out.println(cStr);
		int index = cStr.indexOf('.');
		String s = cStr.substring(index+1);
//		System.out.println(s);
		boolean flag = false;
		for(int i = 0; i < s.length() && !flag; i++){
			for(int j = i+1; j <= s.length(); j++){
				int len = j - i;
//				System.out.println(s.substring(i, j) + "   " + len);
				String tmp = s.substring(i, i+len);
				String lastTmp = s.substring(i+len);
				if(lastTmp.indexOf(tmp) == 0){
					System.out.println(i + " " + len);
					flag = true;
					break;
				}
			}
		}
		if(!flag){
			System.out.println(s.length() + " 0");
		}
	}
}