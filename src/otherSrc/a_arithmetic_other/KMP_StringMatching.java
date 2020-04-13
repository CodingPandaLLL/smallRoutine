package a_arithmetic_other;

public class KMP_StringMatching {

	public static void main(String[] args) {
		String s = "abcdefabchijcdefgiijhg";
		String t = "cdefg";
		int index = KMPIndex(s, t);
		if(index != -1){
			System.out.println("子串t在主串s中的起始位置是：" + index);
		}else{
			System.out.println("主串s中不包含子串t！");
		}
	}
	
	public static int KMPIndex(String s, String t){
		int[] next = new int[t.length()];
		int i = 0, j = 0;	//i指向主串中要比较的位置，j指向子串中要比较的位置
		getNext(t, next);
		while(i < s.length() && j < t.length()){
			if(j == -1 || s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			}else{				//不相等则j回退，i不变
				j = next[j];
			}
		}
		if(j >= t.length()){
			return (i - t.length());
		}else{
			return -1;
		}
	}
	
	
	public static void getNext(String t, int[] next){
		int j, k;
		j = 0; k  = -1; next[0] = -1;
		while(j < t.length() - 1){
			if(k == -1 || t.charAt(j) == t.charAt(k)){
				j++;
				k++;
				next[j] = k;
			}else{
				k = next[k];
			}
		}
	}
}
