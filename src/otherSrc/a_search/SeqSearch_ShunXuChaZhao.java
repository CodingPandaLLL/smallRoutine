package a_search;

public class SeqSearch_ShunXuChaZhao {

	public static void main(String[] args) {
		int[] a = {2, 3, 10, 15, 20, 25, 28, 29, 30, 35};		//10个元素
		
		int key = 20;
		int n = 10;
		int index = seqSearch(a, n, key);	//找出关键字20对应的下标，未找到返回-1
		
		if(index == -1){
			System.out.println("未找到关键字" + key);
		}else{
			System.out.println("关键字" + key + "在数组中的下标为：" + index);
		}
	}
	
	public static int seqSearch(int[] a, int n, int key){
		int i = 0;
		while(i < n && a[i] != key){
			i++;
		}
		if(i >= n){
			return -1;		//未找到key
		}else{
			return i;		//找到返回下标i
		}
	}
}
