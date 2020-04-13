package algorithm;

/**
 * @author lll
 * @time 2019年6月4日下午4:48:35
 * @describe TODO
 */
public class ShellSort {

    /**
     * @time 2019年5月19日下午1:11:59
     * @author lll
     * @describe 希尔排序是高级版直接查找排序，所以也是不稳定排序
     */
    public static int[] shell(int[] intArr) {

        int i = intArr.length;
        // 第一次循环将以此将增量缩写，直至为1
        for (i = i / 2; i >= 1; i = i / 2) {

            // 第二次循环
            for (int j = 0; j < i; j++) {

                // 第二、三次循环查找每个增量对应的分组数据
                for (int m = j + i; m < intArr.length; m = m + i) {
                    int n;
                    int temp = intArr[m];
                    // 第四次循环对分组数据进行直接查找排序
                    for (n = m - i; n >= 0 && intArr[n] > temp; n = n - i) {
                        intArr[n + i] = intArr[n];
                    }
                    intArr[n + i] = temp;
                }
            }
        }

        return intArr;

    }


    public static void main(String[] args) {
        int[] x = {3, 8, 9, 7, 2, 5, 5};

        // 调用希尔排序测试
        int[] m = shell(x);
        System.out.println(" ");
        System.out.print("希尔排序结果：");
        for (int n : m) {
            System.out.print(n);
        }
    }

}
