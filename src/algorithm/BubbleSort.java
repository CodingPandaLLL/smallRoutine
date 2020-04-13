package algorithm;

/**
 * @author lll
 * @time 2019年5月19日下午12:20:59
 * @describe 排序
 */
public class BubbleSort {

    /**
     * @time 2019年5月19日下午1:05:07
     * @author lll
     * @describe 冒泡排序
     */
    public static int[] bubble(int[] intArr) {

        for (int i = 0; i < intArr.length; i++) {
            // 找出本次中最小的值
            for (int j = i; j < intArr.length; j++) {
                if (intArr[j] < intArr[i]) {
                    // 比较交换值
                    int k = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = k;
                }
            }
        }
        return intArr;
    }


    public static void main(String[] args) {
        int[] x = {3, 8, 9, 7, 2, 5, 5};
        // 调用冒泡排序测试
        int[] y = bubble(x);
        System.out.print("冒泡排序结果：");
        for (int z : y) {
            System.out.print(z);
        }

    }

}
