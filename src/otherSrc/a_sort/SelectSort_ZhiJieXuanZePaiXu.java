package a_sort;

public class SelectSort_ZhiJieXuanZePaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int n = 10;
		
		selectSort(a, n);
		
		printArray(a, n);
		
	}
	
	/**
	 * 直接选择排序
	 * 每趟从无序区选出最小的元素，与无序区第一个元素交换，形成新有序区和新无序区
	 * 最开始有序区为空，无序区为整个表
	 * @param a
	 * @param n
	 */
	public static void selectSort(int[] a, int n){
		for(int i = 0; i < n-1; i++){	//因为最后n-1时其实已经全部有序了
			int k = i;
			for(int j = i+1; j < n; j++){
				if(a[j] < a[k]){
					k = j;			//k记录每次从i开始最小的元素的下标
				}
			}
			if(k != i){			//如果最小的元素不是第i个，那就交换i与k，形成新的有序区a[0..i]和无序区a[i+1..n-1]
				int tmp = a[i];
				a[i] = a[k];
				a[k] = tmp;
			}
		}
	}
	
	/**
	 * 打印数组
	 * @param a
	 * @param n
	 */
	public static void printArray(int[] a, int n){
		for(int i = 0; i < n-1; i++){
			System.out.print(a[i] + ",");
		}
		System.out.print(a[n-1]);
	}
}
