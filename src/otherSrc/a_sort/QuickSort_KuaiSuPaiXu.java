package a_sort;

public class QuickSort_KuaiSuPaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int n = 10;
		
		quickSort(a, 0, n-1);
		
		printArray(a, n);
		
	}
	
	/**
	 * 快速排序
	 * 采用两个指针分别指向待排序区的首尾元素，首先将首元素保存到tmp中作为基准，
	 * 令j自end起向左扫描直至a[j] < tmp，将a[j]移至i所指位置上，
	 * 然后令i从i+1起向后扫描直至a[i] > tmp时，将a[i]移至j所指的位置上
	 * 这样重复操作直至i==j，此时a[i]前面的所有元素关键字都小于tmp，后面的都大于tmp，将tmp放到a[i]处，一趟排序完成
	 * 递归排序左半边和右半边
	 * @param a
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] a, int start, int end){	//对a[start]到a[end]的元素进行快排
		int i = start, j = end;
		int tmp;
		if(start < end){										//区间内至少存在两个元素的情况
			tmp = a[start];										//选取区间第一个元素作为基准
			while(i != j){										//从区间两端交替向中间扫描，直至i=j为止
				while(j > i && a[j] >= tmp){					//从右向左扫描，找第一个小于tmp的a[j]
					j--;
				}
				a[i] = a[j];									//将小于tmp的a[j]放到a[i]处
				while(i < j && a[i] <= tmp){					//从左向右扫描，找第一个大于tmp的a[i]
					i++;
				}
				a[j] = a[i];									//将大于tmp的a[i]放到a[j]处
			}
			a[i] = tmp;											//上面到i=j时循环结束，那么一趟快排结束，将中间元素归位
			quickSort(a, start, i-1);							//对左区间递归排序
			quickSort(a, i+1, end);								//对右区间递归排序
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
