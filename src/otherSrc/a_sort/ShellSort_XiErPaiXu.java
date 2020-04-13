package a_sort;

public class ShellSort_XiErPaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int n = 10;
		
		shellSort(a, n);
		
		printArray(a, n);
		
	}
	
	/**
	 * 希尔排序
	 * 即分组直接插入排序
	 * 每次取一个增量di(i = 1..)，将所有相互之间距离为di的倍数的元素放在同一个组中，在各组内进行直接插入排序
	 * 然后取下一个增量dj(j>i,dj<di)重复上述分组和排序过程，直至选择的增量d到1，即所有元素都在同一个组进行直接插入排序
	 * @param a
	 * @param n
	 */
	public static void shellSort(int[] a, int n){
		int d = n/2;		//取初始增量d为n/2
		while(d > 0){
			for(int i = d; i < n; i++){		//直接插入排序，从第一个分组的第一个元素开始，因为第一个分组的第0个元素已有序
				int tmp = a[i];
				int j = i - d;
				while(j >= 0 && tmp < a[j]){	//对相隔d位置的元素组采用直接插入排序
					a[j+d] = a[j];
					j = j - d;
				}
				a[j+d] = tmp;
			}
			d = d/2;				//减小增量
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
