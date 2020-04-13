package a_search;

public class BinSearch_ZheBanChaZhao {

	public static void main(String[] args) {
		int[] a = {2, 3, 10, 15, 20, 25, 28, 29, 30, 35};		//10个元素,二分查找要求元素有序
		
		int key = 20;
		int n = 10;
		int index = binSearch(a, n, key);	//找出关键字20对应的下标，未找到返回-1
		
		if(index == -1){
			System.out.println("未找到关键字" + key);
		}else{
			System.out.println("关键字" + key + "在数组中的下标为：" + index);
		}
	}
	
	public static int binSearch(int[] a, int n, int key){
		int low = 0;
		int high = n - 1;
		int mid;
		while(low <= high){
			mid = (low + high) / 2;
			if(a[mid] == key){
				return mid;
			}else if(a[mid] > key){
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return -1;
	}
}
