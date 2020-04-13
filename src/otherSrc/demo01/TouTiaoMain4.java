package demo01;

import java.util.Scanner;

public class TouTiaoMain4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int h = 0; h < N; h++){
			String s = sc.nextLine();
			s = sc.nextLine();
			String[] str = s.split(" ");
			int k = Integer.parseInt(str[0]);
			float[] a = new float[str.length-1];
			for(int i = 0; i < a.length; i++){
				a[i] = Float.parseFloat(str[i+1]);
			}
			
			String[] r = new String[k];
			int c = 0;
			int n = a.length;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < a.length; j++){
					if(c < k-1){
						if(a[i]/a[n-j] <= a[j]/a[n-i]){
							i++;
							r[c] = a[i] + "-" + a[n-j];
							c++;
						}else{
							j++;
							r[c] = a[j] + "-" + a[n-i];
							c++;
						}
					}
				}
			}
			String[] tmp = r[k-1].split("-");
			System.out.println(tmp[0] + " " + tmp[1]);
		}
	}
	
}
