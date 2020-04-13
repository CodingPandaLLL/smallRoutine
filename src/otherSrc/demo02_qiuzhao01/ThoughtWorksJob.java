package demo02_qiuzhao01;

public class ThoughtWorksJob {
	static int n;
	static int m;

	public static void main(String[] args) {
		String inputString = "3 3\n0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1";
		renderMaze(inputString);
	}
	
	public static void renderMaze(String inputString){
		String outputString = "";
		int enterIndex = inputString.indexOf("\n");
		//连通性数组
		String[] connectDefinitionStrs = inputString.substring(enterIndex+1).split(";");
		try{
			String[] tmp = inputString.substring(0, enterIndex).split(" ");
			n = Integer.parseInt(tmp[0]);
			m = Integer.parseInt(tmp[1]);
			if(n < 0 || m < 0){
				outputString = "Number out of range​.​";
				System.out.println(outputString);
				return ;
			}
			//迷宫数组：0为墙壁，1为道路
			int[][] maze = new int[2*n+1][2*m+1];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					maze[2*i+1][2*j+1] = 1;
				}
			}
			//将连通的道路渲染到迷宫数组中
			if(renderMazeRoad(maze, connectDefinitionStrs)){
				//渲染好了，就转为字符串输出
				outputString = printMaze(maze);
				System.out.println(outputString);
				return ;
			}else{
				return ;
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
			outputString = "Invalid number format​.";
			System.out.println(outputString);
			return ;
		}catch(IndexOutOfBoundsException e){
			outputString = "Incorrect command format​.​";
			System.out.println(outputString);
			return ;
		}
	}
	
	/**
	 * 循环将连通性设置到迷宫矩阵中
	 * @param maze
	 * @param connectStrs
	 * @return
	 */
	public static boolean renderMazeRoad(int[][] maze, String[] connectStrs){
		int len = connectStrs.length;
		String tmp = "";	//每一组：0,1 0,2
		for(int i = 0; i < len; i++){
			tmp = connectStrs[i];
			String[] connects = tmp.split(" ");	//2个元素，如[0]:0,1  [1]:0,2
			int[][] oneConnect = new int[2][2];	//转换成数字{[0,1][0,2]}
			if(connects.length != 2){
				System.out.println("Incorrect command format​.​");
				return false;
			}
			for(int j = 0; j < 2; j++){
				oneConnect[j][0] = Integer.parseInt(connects[j].split(",")[0]);
				oneConnect[j][1] = Integer.parseInt(connects[j].split(",")[1]);
			}
			//检查网格连通性并把连通的道路设置到矩阵中
			if(checkConnect(oneConnect, maze)){
				
			}else{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 检查该条连通性是否合法，合法则将矩阵对应位置设为道路并返回true，否则输出错误信息并返回false
	 * （其中若有数字转化错误，会向上层抛，直到被捕获并处理）
	 * @param connect
	 * @param maze
	 * @return
	 */
	public static boolean checkConnect(int[][] connect, int[][] maze){
		int x1 = connect[0][0];
		int y1 = connect[0][1];
		int x2 = connect[1][0];
		int y2 = connect[1][1];
		if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || x2 < 0 || x2 >= n || y2 < 0 || y2 >= m ){
			System.out.println("Number out of range​.​");
			return false;
		}
		if(x1 == x2 - 1 && y1 == y2){	//(x1, y1)在(x2, y2)上面
			maze[2*x1+2][2*y1+1] = 1;
		}else if( x2 == x1 - 1 && y1 == y2){	//(x1, y1)在(x2, y2)下面
			maze[2*x2+2][2*y2+1] = 1;
		}else if(x1 == x2 && y1 == y2 - 1){	//(x1, y1)在(x2, y2)左面
			maze[2*x1+1][2*y1+2] = 1;
		}else if( x1 == x2 && y1 == y2 + 1){	//(x1, y1)在(x2, y2)右面
			maze[2*x2+1][2*y2+2] = 1;
		}else{
			System.out.println("Maze format error.​");
			return false;
		}
		return true;
	}
	
	/**
	 * 将矩阵转化为字符串
	 * @param maze
	 * @return
	 */
	public static String printMaze(int[][] maze){
		StringBuilder sb = new StringBuilder();
		int mazeN = maze.length;
		int mazeM = maze[0].length;
		for(int i = 0; i < mazeN; i++){
			for(int j = 0; j < mazeM; j++){
				if(maze[i][j] == 0){
					sb.append("[W] ");
				}else{
					sb.append("[R] ");
				}
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		return sb.toString();
	}
}
