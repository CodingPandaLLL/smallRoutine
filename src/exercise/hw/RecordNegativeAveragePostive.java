    package exercise.hw;

    import java.math.BigDecimal;
    import java.util.Scanner;

    /*
    题目描述
    首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
    输入描述:
    首先输入一个正整数n，
    然后输入n个整数。
    输出描述:
    输出负数的个数，和所有正整数的平均值。
    示例1
    输入
    5
    1
    2
    3
    4
    5
    输出
    0 3.0
     */
    public class RecordNegativeAveragePostive {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()){
                int n = sc.nextInt();
                int[] numArr = new int[n];
                for (int i = 0; i < n; i++) {
                    numArr[i] = sc.nextInt();
                }
                int recordNegative = 0;
                int recordPostive = 0;
                int sumPostive = 0;
                for (int i = 0; i < n; i++) {
                    if (numArr[i] > 0) {
                        sumPostive = sumPostive + numArr[i];
                        recordPostive++;
                    }
                    if (numArr[i] < 0) {
                        recordNegative++;
                    }
                }
                BigDecimal averagePostive = new BigDecimal(sumPostive).divide(new BigDecimal(recordPostive), 1, BigDecimal.ROUND_HALF_UP);
                System.out.println(recordNegative + " " + averagePostive);
            }
        }
    }
