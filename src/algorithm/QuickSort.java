package algorithm;

public class QuickSort {


    public static void quick(int[] intArr, int low, int high) {

        int i = low, j = high;
        int x = intArr[low];
        ;
        while (i < j) {
            while (i < j && intArr[j] >= x) {
                j--;
            }

            while (i < j && intArr[i] <= x) {
                i++;
            }

            if (i < j) {
                int temp = intArr[i];
                intArr[i] = intArr[j];
                intArr[j] = temp;
            }
        }
        intArr[low] = intArr[i];
        intArr[i] = x;
        quick(intArr, low, j - 1);
        quick(intArr, j + 1, high);


        // return intArr;
    }


    public static void main(String[] args) {
        int[] x = {3, 8, 9, 7, 2, 5, 5};

        // 调用堆排序测试
        quick(x, 0, x.length - 1);
        System.out.println(" ");
        System.out.print("快速排序结果：");
        for (int n : x) {
            System.out.print(n);
        }
    }

}
