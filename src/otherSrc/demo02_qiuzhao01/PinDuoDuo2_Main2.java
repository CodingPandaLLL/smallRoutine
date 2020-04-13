package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * AC
 * @author lllzj
 *
 */
public class PinDuoDuo2_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] row = new String[n];
		char[][] arr = new char[n][m];
		for(int i = 0; i < n; i++){
			row[i] = sc.next();
			arr[i] = row[i].toCharArray();
		}
		for(int j = 0; j < m; j++){	//从0到m-1列
			for(int i = n-1; i >= 0; i--){	//从n-1到0行
				if(arr[i][j] == 'o'){
					update(arr, i, j, n);
				}
			}
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void update(char[][] arr, int i, int j, int n){
		if(i == n-1){
			arr[i][j] = '.';
			return;
		}else{
			for(int k = i+1; k < n; k++){
				if(arr[k][j] == '.'){
					if(k == n-1){						
						arr[k-1][j] = '.';
						arr[k][j] = '.';
					}else{
						arr[k-1][j] = '.';
						arr[k][j] = 'o';
					}
				}else{
					//下一个是木块或者障碍物
					break;
				}
			}
		}
	}
}
