package demo02_qiuzhao01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PinDuoDuoMain4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String str = sc.nextLine();
		str = sc.next();
		char[] strCh = str.toCharArray();
		int[] phone = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++){
			phone[i] = strCh[i] - '0';
			sum += phone[i];
		}
		int avg = (int) Math.round(sum/(N * 1.0));
		int[] d = new int[N];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < N; i++){
			d[i] = Math.abs(phone[i] - avg);
			if(!map.containsKey(d[i])){
				map.put(d[i], 1);
			}else{
				map.put(d[i], map.get(d[i])+1);
			}
		}
		int[] sortD = d;
		quickSort(sortD, 0, N-1);
		int min = sortD[0];
		int count = 0;
		while(K > 0){
			int t = map.get(min);
			if(K - t >= 0){
				K -= t;
				count += t;
				for(int i = 0; i < N; i++){
					if(d[i] == min){
						phone[i] = avg;
					}
				}
				for(int i = 0; i < N; i++){
					if(sortD[i] > min){
						min = sortD[i];
					}
				}
			}else{
				int lastC = K - t;
				for(int i = 0; i < N && lastC > 0; i++){
					if(d[i] == min){
						phone[i] = avg;
						lastC--;
						count ++;
					}
				}
				break;
			}
		}
		
		System.out.println(count);
		String result = "";
		for(int i = 0; i < N; i++){
			result += phone[i];
		}
		System.out.println(result);
	}
	
	public static void quickSort(int[] a, int start, int end){
		int i = start, j = end;
		int tmp;
		if(start < end){
			tmp = a[start];	
			while(i != j){
				while(j > i && a[j] >= tmp){
					j--;
				}
				a[i] = a[j];
				while(i < j && a[i] <= tmp){
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
