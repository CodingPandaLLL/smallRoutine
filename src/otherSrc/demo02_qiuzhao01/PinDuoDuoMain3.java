package demo02_qiuzhao01;

import java.util.Scanner;

public class PinDuoDuoMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] strArr = s.trim().split(" ");
		int len = strArr.length;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		quickSort(arr, 0, len-1); 	//从大到小排序先
		int i = 0, j = len-1;
		int c = 0;
		while(i < j){
			int tmp = 300 - arr[i];
			if(tmp < arr[j]){	//如果装了最大的就装不下最小的了，那么久只能一个货物耗费一辆车
				i++;
			}else{
				if(j-1 > i && (tmp - arr[j] > arr[j-1])){
					i++;
					j-=2;
				}else{
					i++;
					j--;
				}
			}
			c ++;
		}
		if(i == j){
			c++;
		}
		System.out.println(c);
	}
	
	public static void quickSort(int[] a, int start, int end){
		int i = start, j = end;
		int tmp;
		if(start < end){
			tmp = a[start];	
			while(i != j){
				while(j > i && a[j] <= tmp){
					j--;
				}
				a[i] = a[j];
				while(i < j && a[i] >= tmp){
					i++;
				}
				a[j] = a[i];								
			}
			a[i] = tmp;
			quickSort(a, start, i-1);
			quickSort(a, i+1, end);	
		}
	}
}
