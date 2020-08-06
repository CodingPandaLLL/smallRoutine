package exercise.hw;

import java.util.*;

/*
输入描述:
输入一个long型整数
输出描述:
按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 */
public class ZhiYinZi {

    public static void main(String[] args) {
        //第一步找出所有小于X的质子
        Scanner sc = new Scanner(System.in);
        long X = sc.nextLong();
        List<Integer> keyList = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        if (X == 1) {
            System.out.println("1 ");
            return;
        }
        if (X == 2) {
            System.out.println("2 ");
            return;
        }
        if (isZhiYinzi((int) X)) {
            System.out.println(X + " ");
            return;
        }
        for (int i = 1; i < X; i++) {
            //判断i是否为质子方法
            if (isZhiYinzi(i)) {
                keyList.add(i);
            }
        }
        //用找到的所有找到的质子，整除X，能够被整除的即为质因子
        for (int j = 0; j < keyList.size(); j++) {
            if (X % keyList.get(j) == 0) {
                resultList.add(keyList.get(j));   //找到质子存到结果集
                if (1 != X / keyList.get(j)) {        //判断是否为最后一个质因子
                    X = X / keyList.get(j);         //不是最后走一个质因子更新X的值
                    j--;                          //以上个质子继续判断
                } else {
                    break;                        //找到最后一个质子跳出循环
                }
            }
        }

        //打印结果
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i));
            System.out.print(" ");
        }
    }

    //判断i是否为质子方法
    private static boolean isZhiYinzi(int i) {
        if (i < 2) {
            return false;
        }
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

}
