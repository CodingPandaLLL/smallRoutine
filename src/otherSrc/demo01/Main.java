package demo01;

import java.util.Scanner;
/**
 * 
3
o^-
/v|
vx^
< |
5
x>-o\
voooo
|ooo/
ooo/v
\o/vv
| \ |
 * @author zj
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			String[][] a = new String[n][n];
			for(int i = 0; i < n; i++){
				String ss = sc.next();
				char[] c = ss.toCharArray();
				for(int j = 0; j < n; j++){
					a[i][j] = String.valueOf(c[j]); 
				}
			}
			String[][] b = new String[n][n];
			String cmd = sc.nextLine();
			cmd = sc.nextLine();
			String[] c = cmd.split(" ");
			for(int i = 0; i < c.length; i++){
				b = executeCmd(a,c[i],n);
				a = b;
			}
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					System.out.print(b[i][j]);
				}
				System.out.println();
			}
		}
	}

	public static String[][] executeCmd(String[][] a, String c, int n) {
		String[][] result = new String[n][n];
		if(c.equals("<")){
			for(int i = 0; i < n; i++){
				for(int j =0; j < n; j++){
					result[n-1-j][i] = change(a[i][j], "<");
				}
			}
		}else if(c.equals("-")){
			for(int i = 0; i < n; i++){
				for(int j =0; j < n; j++){
					result[n-1-i][j] = change(a[i][j], "-");
				}
			}
		}else if(c.equals("|")){
			for(int i = 0; i < n; i++){
				for(int j =0; j < n; j++){
					result[i][n-1-j] = change(a[i][j], "|");
				}
			}
		}else if(c.equals(">")){
			for(int i = 0; i < n; i++){
				for(int j =0; j < n; j++){
					result[j][n-1-i] = change(a[i][j], ">");
				}
			}
		}else if(c.equals("\\")){
			for(int i = 0; i < n; i++){
				for(int j =0; j < n; j++){
					result[j][i] = change(a[i][j], "\\");
				}
			}
		}else if(c.equals("/")){
			for(int i = 0; i < n; i++){
				for(int j =0; j < n; j++){
					result[n-1-j][n-1-i] = change(a[i][j], "/");
				}
			}
		}
		
		return result;
	}

	private static String change(String c, String cmd) {
		String[] s = {"<", ">", "^", "v", "o", "x", "|", "-","/", "\\"};
		String[] s1 = {"v", "^", "<", ">", "o", "x", "-", "|","\\", "/"};
		String[] s2 = {"<", ">", "v", "^", "o", "x", "|", "-","\\", "/"};
		String[] s3 = {">", "<", "^", "v", "o", "x", "|", "-","\\", "/"};
		String[] s4 = {"^", "v", ">", "<", "o", "x", "-", "|","\\", "/"};
		String[] s5 = {"^", "v", "<", ">", "o", "x", "-", "|","/", "\\"};
		String[] s6 = {"v", "^", ">", "<", "o", "x", "-", "|","/", "\\"};
		for(int i = 0; i < 10; i++){
			if(s[i].equals(c)){
				if(cmd.equals("<"))
					return s1[i];
				else if(cmd.equals("-"))
					return s2[i];
				else if(cmd.equals("|"))
					return s3[i];
				else if(cmd.equals(">"))
					return s4[i];
				else if(cmd.equals("\\"))
					return s5[i];
				else if(cmd.equals("/"))
					return s6[i];
			}
		}
		return null;
	}
}
