package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 9%
 * @author lllzj
 *
 */
public class MeiTuan_Main1 {
	
	private static int curWay = 0;	//当前路程
	private static int min = Integer.MAX_VALUE;	//最小路程

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n+2][n+2];
		for(int i = 0; i < n-1; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		 if(n == 1){
            System.out.println(0);
        }else if(n == 2){
            System.out.println(1);
        }else{
			boolean[] flag = new boolean[n+2];
			flag[1] = true;
			findWay(map, n, 1, 1, flag);
			System.out.println(min);
        }
	}
	
	public static boolean findWay(int[][] map, int n, int cur, int len, boolean[] flag){
		if(len == n){
			min = Math.min(min,  curWay);
			return true;
		}
		for(int i = 1; i < n+1; i++){
			if(map[cur][i] == 1 && !flag[i]){	//如果从当前点到i有边，且i没走过
				curWay++;
				len++;
				flag[i] = true;
//				System.out.println(cur + "->" + i + ", " + len);
				boolean f = findWay(map, n, i, len, flag);
				if(f){	//如果沿着可以访问完
					curWay--;
					len--;
					flag[i] = false;
					
				}else{	//访问不完说明又要走回来
//					System.out.println(i + "->" + cur + ", " + len);
					curWay++;
				}
			}
		}
		return false;
	}
}
