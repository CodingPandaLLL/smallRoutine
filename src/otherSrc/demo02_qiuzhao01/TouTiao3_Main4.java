package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 60%
 * @author lllzj
 *
 */
public class TouTiao3_Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			if(a[i] >= 240){
				if(a[i] < 248 && n-i >= 4){
					i++;
					if(a[i] >= 128 && a[i] < 192){
						i++;
						if(a[i] >= 128 && a[i] < 192){
							i++;
							if(a[i] >= 128 && a[i] < 192){
								
							}else{
								System.out.println(0);
								return;
							}
						}else{
							System.out.println(0);
							return;
						}
					}else{
						System.out.println(0);
						return;
					}
				}else{
					System.out.println(0);
					return;
				}
			}else if(a[i] >= 224){
				if(a[i] < 240 && n-i >= 3){
					i++;
					if(a[i] >= 128 && a[i] < 192){
						i++;
						if(a[i] >= 128 && a[i] < 192){
							
						}else{
							System.out.println(0);
							return;
						}
					}else{
						System.out.println(0);
						return;
					}
				}else{
					System.out.println(0);
					return;
				}
			}else if(a[i] >= 192){
				if(a[i] < 224 && n-i >= 2){
					i++;
					if(a[i] >= 128 && a[i] < 192){
						
					}else{
						System.out.println(0);
						return;
					}
				}else{
					System.out.println(0);
					return;
				}
			}else{
				
			}
		}
		System.out.println(1);
	}
}
