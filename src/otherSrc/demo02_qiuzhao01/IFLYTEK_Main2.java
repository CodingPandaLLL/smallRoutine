package demo02_qiuzhao01;

import java.util.Scanner;

public class IFLYTEK_Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		boolean[] f = new boolean[n];	//代表该人是否还活着
		int[] right = new int[n];		//代表每个人的右边的人的编号
		for(int i = 0; i < n; i++){
			a[i] = sc.nextInt();
			f[i] = true;
			if(i > 0){
				right[i-1] = i;	//第i-1个人旁边人的编号是i
			}
		}
		right[n-1] = -1;
		int result = 0;
		if(checkSafe(a, f, right, n)){	//初始检查一下是不是安全的，是则返回0
			System.out.println(0);
		}else{							//否则杀手开始杀人
			boolean isSafe = false;
			while(!isSafe){				//没轮杀完人后检查一下是不是安全的
				for(int i = 0; i < n-1; i++){
					int t = i;			//从第i个杀手开始
					if(f[t] && f[right[t]]){	//如果这个杀手还活着并且它右边的杀手也还活着
						int j = right[t];
						if(a[t] > a[j]){		//如果这个杀手比他右边的编号大，则可以杀
							f[j] = false;		//右边的杀手被杀，状态为false
							System.out.println(a[t] + " killaaa " + a[j]);
							if(j < n-1){		//判断右边的杀手是不是最后一个，不是则继续向后杀人
								t = j;			//更新要杀人的杀手为刚刚被杀的那个
								j = right[j];	//更新要被杀的人
								while(j < n && j!= -1 && a[t] > a[j] && f[j]){	//如果没到最后一个（j!=-1）并且当前可以杀人
									f[j] = false;
									System.out.println(a[t] + " kill " + a[j] + "--" + f[j]);
									t = j;	//杀完继续更新
									j = right[j];
								}
								right[i] = j;
							}
						}
					}
				}
				result++;	//每轮杀人完毕说明过了一夜
				if(checkSafe(a, f, right, n)){
					isSafe = true;
				}
			}
		}
		System.out.println(result);
	}
	
	public static boolean checkSafe(int[] a, boolean[] f, int[] right, int n){
		boolean result = true;
		for(int i = 0; i < n && right[i] != -1; i++){	//注意检查是否是最后一个人了（下一个人的编号是-1就说明后面没人活着了）
			if(f[i] && f[right[i]] && a[i] > a[right[i]]){
				result = false;
				break;
			}
		}
		return result;
	}
}
