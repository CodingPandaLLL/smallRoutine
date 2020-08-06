package exercise.hw;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author lll
 * @time 2019年12月17日下午1:36:44
 * @describe 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class SkipLocation {

    public static void reOrderArray(int[] array) {
        ArrayList<Integer> ou = new ArrayList<Integer>();
        ArrayList<Integer> ji = new ArrayList<Integer>();
        // 判断奇数偶数存到不同的位置
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                ou.add(array[i]);
            } else {
                ji.add(array[i]);
            }
        }
        // 合并
        ji.addAll(ou);
        // 重新赋值
        for (int i = 0; i < ji.size(); i++) {
            array[i] = ji.get(i);
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<Integer>();

        // 循环输入并存到list中
        while (sc.hasNextInt()) {
            input.add(sc.nextInt());
        }

        // 打印输入
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println("");

        // 数据类型转换为数组
        int[] ints = new int[input.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = input.get(i);
        }
        // 调用处理
        reOrderArray(ints);
        // 处理后打印
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }
}

