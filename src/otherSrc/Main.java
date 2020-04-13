public class Main {
	static int M = 3;
	static int[] a = new int[] { 1, 2, 3, 4, 5 };
	static int N = a.length;
	static int[] b = new int[M];

	public static void main(String[] args) {
		C(N, M);
	}

	static void C(int m, int n) {
		int i, j;
		for (i = n; i <= m; i++) {
			b[n - 1] = i - 1;
			if (n > 1) {
				C(i - 1, n - 1);
			} else {
				for (j = 0; j <= M - 1; j++)
					System.out.print(a[b[j]] + "  ");
				System.out.println();
			}
		}
	}
}
