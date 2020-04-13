package algorithm;

/**
 * @author lll
 * @time 2019年5月19日下午12:20:59
 * @describe 排序
 */
public class SimpleSelectSort {

    /**
     * @time 2019年5月19日下午1:11:59
     * @author lll
     * @describe 简单选择排序 简单选择排序的不稳定性：对于相同值的数排序后不会改变其key对应的位置的算法为稳定的，反之为不稳定的，简单选择排序是会交换位置的，所以是不稳定的算法
     */
    public static int[] simpleSelect(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            int p = i;

            /*
             * 寻找i前面的最小值,定位给p
             */
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[p] > intArr[j]) {
                    p = j;
                }
            }

            /*
             * 最小值与i交换值
             */
            int tmp = intArr[i];
            intArr[i] = intArr[p];
            intArr[p] = tmp;

        }
        return intArr;
    }


    public static void main(String[] args) {
        int[] x = {3, 8, 9, 7, 2, 5, 5};

        // 调用简单选择排序测试
        int[] m = simpleSelect(x);
        System.out.println(" ");
        System.out.print("简单选择排序结果：");
        for (int n : m) {
            System.out.print(n);
        }
    }

}
