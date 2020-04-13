package demo01;

import java.util.Scanner;

/**
 * 在自动化仓库中有若干障碍物，机器人需要从起点出发绕过这些障碍物到终点搬取货柜，现试求机器人从起点运动到终点用时最短的路径。 已知机器人只能沿着东西方向或南北方向移动，移动的速度为1m/s，机器人每转向90度需要花费1s。
	
	 输入： 
	第一行：起点位置坐标及机器人朝向，如： 
	1 0 EAST
	代表机器人初始坐标为x=1,y=0，机器人面朝东方 
	第二行：终点位置坐标及机器人朝向，如： 
	0 2 WEST
	代表机器人需要移动至点x=0,y=2，且面朝西方 
	接下来输入的是地图： 
	首先是两个数字r,c，代表有地图数据有多少行与多少列，如：
	2 3
	0 1 0
	0 0 0 
	其中，左上角为坐标原点，从左向右为x轴增大的方向是东方，从上到下为y轴增大的方向是南方。
	地图中1代表有障碍物，机器人不能前往，0代表无障碍物机器人可以前往 地图中相邻的每两个点之间的距离为1m。
	0 <= l,w <= 128 
	输出： 
	机器人从起点移动到终点所需要的最短秒数，当不可达时输出65535
 * @author zj
 *
 */
public class AlibabaMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		String start = sc.next();
		int ex = sc.nextInt();
		int ey = sc.nextInt();
		String end = sc.next();
		int r = sc.nextInt();	//行
		int c = sc.nextInt();	//列
		int[][] map = new int[r][c];
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				map[i][j] = sc.nextInt();
			}
		}
		int time;
		if(ex < 0 || ex >= r || ey < 0 || ey >= c || map[ex][ey] == 1){
			System.out.println("65535");
		}else{
			 for(int i = sx; i < r;){
				 for(int j = sy; j < c;){
					 //四个方向:上右下左：1234
					 for(int k = 1; k <= 4; k++){
						 
					 }
					 
				 }
			 }
		}
	}
}
