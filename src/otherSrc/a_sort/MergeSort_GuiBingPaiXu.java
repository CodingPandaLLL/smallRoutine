package a_sort;

public class MergeSort_GuiBingPaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};	//这里前面的a[0]不会用到，因为完全二叉树的编号是1-n
		int n = 10;		//要排序的元素还是10个
		
		mergeSort(a, n);
		
		printArray(a, a.length);	//输出时也没输出a[0]
		
	}
	
	/**
	 * 归并排序
	 * 		自底向上的二路归并算法
	 * @param a
	 * @param n
	 */
	public static void mergeSort(int[] a, int n){
		for(int length = 1; length < n; length = 2 * length){
			mergePass(a, length, n);			//进行log2 n趟归并
		}
	}
	
	/**
	 * 对整个表进行一趟归并
	 * @param a
	 * @param length	每组数据中的元素个数
	 * @param n		要归并的元素总个数
	 */
	public static void mergePass(int[] a, int length, int n){
		int i;
		for(i = 0; i + 2 * length -1 < n; i = i + 2 * length){		//归并length长的两相邻子表
			merge(a, i, i+length-1, i+2*length-1);
		}
		if(i+length-1 < n){				//因为i+length-1<n所以一定余下两个子表，且后者长度小于length，否则就在上面归并完了
			merge(a, i, i+length-1, n-1);	//归并这两个表
		}
		//如果只剩一个就不管它，这趟轮空
	}
	
	/**
	 * 一次二路归并的算法
	 * 		从1,2两段中各取一个元素比较，将较小的放入新数组b中，
	 * 		再去较小的那段的下一个元素与前一次较大元素比较，重复直至有一段中元素全部比较完毕
	 * 		将剩下的那段中的余下元素全部复制到b中
	 * @param a
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] a, int low, int mid, int high){
		int[] b = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;		//i,j,k分别为第1,2段和b数组中的下标
		while(i <= mid && j <= high){
			if(a[i] < a[j]){					//将第1段中元素放入b中，i++;k++;
				b[k] = a[i];
				i++;
				k++;
			}else{								//将第2段中元素放入b中，j++;k++;
				b[k] = a[j];
				j++;
				k++;
			}
		}
		while(i <= mid){						//将第1段中余下部分复制到b中
			b[k] = a[i];
			i++;
			k++;
		}
		while(j <= high){						//将第2段中余下部分复制到b中
			b[k] = a[j];
			j++;
			k++;
		}
		
		for(k = 0, i = low; i <= high; k++, i++){	//将b中元素复制回a中指定位置
			a[i] = b[k];
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

