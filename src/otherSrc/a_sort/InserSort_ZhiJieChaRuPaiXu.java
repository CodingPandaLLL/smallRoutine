package a_sort;

public class InserSort_ZhiJieChaRuPaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int n = 10;
		
		insertSort(a, n);
		
		printArray(a, n);
		
	}
	
	/**
	 * 直接插入排序
	 * a[0..i-1]是有序区，a[i..n-1]是无序区，每次将无序区第一个元素插入有序区合适位置
	 * @param a
	 * @param n
	 */
	public static void insertSort(int[] a, int n){
		int tmp;
		for(int i = 1; i < n; i++){			//i从1开始，因为i = 0时已经有序
			tmp = a[i];			//因为后面移动元素时a[i]会被覆盖掉，提前保存
			int j = i - 1;
			while(j >= 0 && tmp < a[j]){
				a[j + 1] = a[j];		//将大于tmp的元素向后移动
				j--;
			}
			a[j+1] = tmp;		//在j+1处插入tmp
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
