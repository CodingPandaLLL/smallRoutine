package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class PinDuoDuo2_Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hp = sc.nextInt();
		int normalAttack = sc.nextInt();
		int buffedAttack = sc.nextInt();
		int result = 0;
		if(normalAttack * 2 < buffedAttack){
			int tmp = hp / buffedAttack;
			int mod = hp % buffedAttack;
			if(mod == 0){
				result = tmp * 2;
			}else{
				if(mod <= normalAttack){
					result = tmp * 2 + 1;
				}else{
					result = tmp * 2 + 2;
				}
			}
		}else{
			int tmp = hp / normalAttack;
			int mod = hp % normalAttack;
			if(mod == 0){
				result = tmp;
			}else{
				result = tmp + 1;
			}
		}
		System.out.println(result);
	}
}
