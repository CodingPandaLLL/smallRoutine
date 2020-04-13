package a_sort;

public class BinaryInserSort_ZheBanChaRuPaiXu {

	public static void main(String[] args) {
		int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int n = 10;
		
		binaryInsertSort(a, n);
		
		printArray(a, n);
		
	}
	
	/**
	 * 折半插入排序
	 * 先采用折半查找方法在a[0..i-1]中找到插入位置，再通过移动元素进行插入
	 * @param a
	 * @param n
	 */
	public static void binaryInsertSort(int[] a, int n){	//对有序区a[0..i-1]按递增顺序进行折半插入排序
		for(int i = 1; i < n; i++){
			int tmp = a[i];							//将啊a[i]保存到tmp中
			int low = 0, high = i-1;
			while(low <= high){						//在a[low..high]中折半查找有序插入的位置
				int mid = (low + high)/2;
				if(tmp < a[mid]){					//插入点在左半边
					high = mid-1;
				}else{								//插入点在右半边
					low = mid + 1;
				}
			}
			for(int j = i-1; j >= high + 1; j--){	//将high+1到i-1位置的元素后移
				a[j+1] = a[j];
			}
			a[high+1] = tmp;						//元素插入a[high+1]
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
