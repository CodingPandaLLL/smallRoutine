package demo02_qiuzhao01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 思路：
 * 
 * @author lllzj
 *
 */
public class Tencent_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		for(int i = 0; i < m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			map[u][v] = 1;
		}
		
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				if(map[i][j] == 1){
					sign(i, j, map, n);
				}
			}
		}
		
		int count = 0;
		for(int k = 1; k < n+1; k++){
			int x = 0, y = 0;
			for(int i = 1; i < n+1; i++){
				if(map[k][i] == 1){
					x++;
				}
				if(map[i][k] == 1){
					y++;
				}
			}
			if(y > x){
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void sign(int u, int v, int[][] map, int n){
		List<Integer> listX = new ArrayList<>();
		List<Integer> listY = new ArrayList<>();
		for(int i = 1; i < n+1; i++){
			if(map[v][i] == 1){
				if(!listX.contains(i)){
					listX.add(i);
					map[u][i] = 1;
					sign(u, i, map, n);
				}
			}
		}
	}
}

/**
 * 牛客别人AC代码
 * 作者：yuan123
链接：https://www.nowcoder.com/discuss/110616
来源：牛客网

import java.util.*;
public class Main{
    static boolean[][] isReach;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        isReach = new boolean[n][n];
        for(int i = 0;i < m;i++){
            isReach[in.nextInt()-1][in.nextInt()-1] = true;
        }
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i!=j&&isReach[i][j]){
                    dfs(i,j,n);
                }
            }
        }
        int[][] num = new int[n][2];
        for(int i = 0;i<n;i++){
            for(int j = 0;j < n;j++){
                if(isReach[i][j]){
                    num[i][0]++;
                    num[j][1]++;
                }
            }
        }
        int sum = 0;
        for(int i = 0;i < n;i++){
            if(num[i][1]>num[i][0]){
                //System.out.println(Arrays.deepToString(isReach));
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static void dfs(int begin,int end,int n){
        for(int i = 0;i < n;i++){
            if(i==end)continue;
            if(isReach[end][i]&&!isReach[begin][i]&&begin!=i){
                isReach[begin][i]=true;
                dfs(begin,i,n);
            }
        }
    }
}
 * **/
