package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class FiberHome_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int k = 0; k < t; k++){
			String a = sc.next();
			String b = sc.next();
			Map<Character, Character> map = new HashMap<Character, Character>();
			Map<Character, Character> reverseMap = new HashMap<Character, Character>();
			boolean f = true;
			for(int i = 0; i <a.length(); i++){
				char ai = a.charAt(i);
				char bi = b.charAt(i);
				if(map.containsKey(ai)){
					if(!map.get(ai).equals(bi) || !reverseMap.get(bi).equals(ai)){
						f = false;
						break;
					}
				}else{
					map.put(ai, bi);
					if(reverseMap.containsKey(bi)){
						f = false;
						break;
					}
					reverseMap.put(bi, ai);
				}
			}
			if(f){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}
