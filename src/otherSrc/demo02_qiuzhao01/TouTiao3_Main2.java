package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 80%
 * @author lllzj
 *
 */
public class TouTiao3_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[][] a = new int[m][m];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				a[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		boolean[][] f = new boolean[m][m];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m; j++){
				if(!f[i][j] && a[i][j] == 1){	//如果是没被访问过的团队
					count++;
					findTeam(a, f, m, i, j);	//将与其一个部门的标志位都标记为true，下次就不会找到它们
				}
			}
		}
		System.out.println(count);
	}
	
	public static void findTeam(int[][] a, boolean[][] f, int m, int x, int y){
		if(x > 0 && a[x-1][y] == 1 && !f[x-1][y]){
			f[x-1][y] = true;
			findTeam(a, f, m, x-1, y);
		}
		if(x < m-1 && a[x+1][y] == 1 && !f[x+1][y]){
			f[x+1][y] = true;
			findTeam(a, f, m, x+1, y);
		}
		if(y > 0 && a[x][y-1] == 1 && !f[x][y-1]){
			f[x][y-1] = true;
			findTeam(a, f, m, x, y-1);
		}
		if(y < m-1 && a[x][y+1] == 1 && !f[x][y+1]){
			f[x][y+1] = true;
			findTeam(a, f, m, x, y+1);
		}
	}
}
