package exercise.hw;

import java.math.BigDecimal;
import java.util.Scanner;

/*
•计算一个数字的立方根，不使用库函数
详细描述：
•接口说明
原型：
public static double getCubeRoot(double input)
输入:double 待求解参数
返回值:double  输入参数的立方根，保留一位小数
eg:  216  输出 6.0
 */
public class CubeRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        double result = 0;
        for (double i = 1; i < num;i=i+0.1) {
            double f = i * i * i;
            BigDecimal b = new BigDecimal(f);
            double f1 = b.setScale(0, BigDecimal.ROUND_FLOOR).doubleValue();
            double f2 = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            if (f1 == num || f2==num) {
                result = i;
                break;
            }
        }
        double f =result;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(1, BigDecimal.ROUND_FLOOR).doubleValue();
        System.out.println(f1);

    }
}
