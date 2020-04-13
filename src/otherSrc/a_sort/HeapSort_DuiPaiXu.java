package a_sort;

public class HeapSort_DuiPaiXu {

	public static void main(String[] args) {
		int[] a = {-1,9, 8, 7, 6, 5, 4, 3, 2, 1, 0};	//这里前面的a[0]不会用到，因为完全二叉树的编号是1-n
		int n = 10;		//要排序的元素还是10个
		
		heapSort(a, n);
		
		printArray(a, a.length);	//输出时也没输出a[0]
		
	}
	
	/**
	 * 堆排序
	 * @param a
	 * @param n
	 */
	public static void heapSort(int[] a, int n){
		for(int i = n/2; i >= 1; i--){		//循环建立初试堆
			sift(a, i, n);
		}
		
		for(int i = n; i >= 2; i--){		//进行n-1趟堆排序，每一趟堆排序的元素减1
			int tmp = a[1];					//将最后一个元素同当前区间内a[1]（也就是已排序出的最大元素）交换
			a[1] = a[i];
			a[i] = tmp;
			sift(a, 1, i-1);				//调整
		}
	}
	
	/**
	 * 堆调整算法
	 * 调整从low到high的节点使之成堆
	 * @param a
	 * @param low
	 * @param high
	 */
	public static void sift(int[] a, int low, int high){
		int i = low, j = 2 * i;		//j指向的是i指向的左孩子
		int tmp = a[i];
		while(j <= high){
			if(j < high && a[j] < a[j+1]){
				j++;	//若右孩子较大，把j指向右孩子
			}
			if(tmp < a[j]){		//如果双亲节点比左右孩子节点中较大的那个小
				a[i] = a[j];	//将a[j]调整到双亲节点位置上
				i = j;			//修改i和j值，以便继续向下筛选
				j = i * 2;
			}else{
				break;
			}
		}
		a[i] = tmp;				//被筛选节点的值放入最终位置
	}
	
	/**
	 * 打印数组
	 * @param a
	 * @param n
	 */
	public static void printArray(int[] a, int n){
		for(int i = 1; i < n-1; i++){
			System.out.print(a[i] + ",");
		}
		System.out.print(a[n-1]);
	}
}
