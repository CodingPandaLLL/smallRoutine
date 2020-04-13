package niuke.demo_1;

public class FibonacciAdd {

	public static void main(String[] args) {
		int result = getNthNumber(1111111112);
		System.out.println(result);
	}
	
	public static int getNthNumber(int n) {
        // write code here
        if(n == 0 || n == 1)
            return 1;
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 1;
        long tmp = 0;
        for(int i = 2; i <= n; i++){
            tmp = f[i-1] + f[i-2];
//            System.out.println(i + "--" + tmp);
            f[i] = (int)(tmp % 1000000007);
        }
        return f[n];
    }
}
