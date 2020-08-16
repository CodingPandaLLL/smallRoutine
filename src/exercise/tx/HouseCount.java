package exercise.tx;

import java.util.Scanner;

/**
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 * * <p>
 * * 输入描述:
 * * 输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
 * * 1<=n<=100000;
 * * 1<=wi<=100000;
 * * <p>
 * * 输出描述:
 * * 输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
 * * <p>
 * * 输入例子1:
 * * 6
 * * 5 3 8 3 2 5
 * * <p>
 * * 输出例子1:
 * * 3 3 5 4 4 4
 * * <p>
 * * 例子说明1:
 * * 当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
 * * <p>
 */
public class HouseCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] strArr=(sc.nextLine()).split(" ");
        int[] kArr = new int[n];
        for (int i = 0; i < strArr.length; i++) {
            kArr[i] = Integer.valueOf(strArr[i]);
        }
        int[] result = new int[n];
        for (int i = 0; i < kArr.length; i++) {
            //找出I前面可以看出栋楼
            int fkey = 0;
            int fMax = 0;
            for (int j = i + 1; j < kArr.length; j++) {
                if (j == i + 1) {
                    fMax=kArr[j];
                    fkey++;
                } else  {
                    if (fMax < kArr[j]) {
                        fkey++;
                        fMax=kArr[j];
                    }
                }
            }
            //找出I后面可以看到几栋楼
            int akey = 0;
            int aMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1) {
                    aMax=kArr[j];
                    akey++;
                } else {
                    if (aMax < kArr[j]) {
                        akey++;
                        aMax=kArr[j];
                    }
                }
            }
            result[i] = akey + fkey + 1;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
