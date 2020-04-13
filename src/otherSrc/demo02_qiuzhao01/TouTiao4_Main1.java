package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 20%
 * @author lllzj
 *
 */
public class TouTiao4_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dir = sc.next();
		if(dir.length() == 1 && dir.equals("/")){
			System.out.println(dir);
		}else{
			if(dir.charAt(dir.length()-1) == '/'){
				dir = dir.substring(0, dir.length()-1);
			}
			int index = dir.indexOf('/');
			int nextIndex = dir.substring(index+1).indexOf('/');
			while(nextIndex >= 0){
				index = nextIndex+1;
//				System.out.println(index + ": " + dir + " --> " + dir.substring(index));
				dir = dir.substring(index);
				nextIndex = dir.substring(1).indexOf('/');
//				System.out.println(nextIndex);
			}
			System.out.println(dir);
		}
	}
}
