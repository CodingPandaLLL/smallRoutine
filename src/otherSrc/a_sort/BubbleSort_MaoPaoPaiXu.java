package a_sort;

public class BubbleSort_MaoPaoPaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int n = 10;
		
		bubbleSort(a, n);
		
		printArray(a, n);
		
	}
	
	/**
	 * 冒泡排序
	 * 从最后一个元素开始向前，两两相邻元素比较，较小的换到较大的前面，一趟冒泡过后，关键字最小的元素到达最前面
	 * @param a
	 * @param n
	 */
	public static void bubbleSort(int[] a, int n){	
		for(int i = 0; i < n; i++){
			for(int j = n-1; j > i; j--){	//从n-1到i，比较找出本趟最小元素将其交换到i位置
				if(a[j] < a[j-1]){			//如果有后面元素小于前一个元素，交换
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
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
