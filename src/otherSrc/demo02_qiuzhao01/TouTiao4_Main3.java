package demo02_qiuzhao01;

import java.util.Scanner;

/**
 * 80%
 * @author lllzj
 *
 */
public class TouTiao4_Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		String[] words = new String[k];
		char[][] dic = new char[n][m];
		for(int i = 0; i < k; i++){
			words[i] = sc.next();
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				dic[i][j] = sc.next().charAt(0);
			}
		}
		for(int i = 0; i < k; i++){
			boolean[][] f = new boolean[n][m];
			boolean result = find(words[i], dic, f, 0, 0, 0, n, m, true);
			if(result){
				System.out.println(words[i]);
			}
		}
	}
	
	public static boolean find(String word, char[][] dic, boolean[][] f, int index, int prex, int prey, int n, int m, boolean isFirst){
//		System.out.println(word + " - "  + word.charAt(index) + " -- "+ index + " : " + prex + "," + prey);
		if(index == word.length()){
			return true;
		}else if(isFirst){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					if(dic[i][j] == word.charAt(index) && f[i][j] == false){
						f[i][j] = true;
						boolean r = find(word, dic, f, index, i, j, n, m, false);
						if(r){
							return true;
						}
					}
				}
			}
			return false;
		}else{
//			System.out.println(word.charAt(index) + " - " + dic[prex][prey]);
			if(word.charAt(index) == dic[prex][prey]){
				if(prex > 0 && f[prex-1][prey] == false){
					f[prex-1][prey] = true;
					boolean r = find(word, dic, f, index+1, prex-1, prey, n, m, false);
					if(r){
						return true;
					}
				}
				if(prex < n-1 && f[prex+1][prey] == false){
					f[prex+1][prey] = true;
					boolean r = find(word, dic, f, index+1, prex+1, prey, n, m, false);
					if(r){
						return true;
					}
				}
				if(prey < m-1 && f[prex][prey+1] == false){
					f[prex][prey+1] = true;
					boolean r = find(word, dic, f, index+1, prex, prey+1, n, m, false);
					if(r){
						return true;
					}
				}
				if(prey > 0 && f[prex][prey-1] == false){
					f[prex][prey-1] = true;
					boolean r = find(word, dic, f, index+1, prex, prey-1, n, m, false);
					if(r){
						return true;
					}
				}
				return false;
			}else{
				return false;
			}
		}
	}
}
