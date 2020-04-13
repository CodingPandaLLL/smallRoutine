package exercise;

import java.util.Scanner;

/*
题目说明

蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
样例输入
5
样例输出
1 3 6 10 15
2 5 9 14
4 8 13
7 12
11
接口说明
原型
void GetResult(int Num, char * pResult);
输入参数：
        int Num：输入的正整数N
输出参数：
        int * pResult：指向存放蛇形矩阵的字符串指针
        指针指向的内存区域保证有效
返回值：
        void
输入描述:
输入正整数N（N不大于100）
输出描述:
输出一个N行的蛇形矩阵。
 */
public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int p = sc.nextInt();
            int max = (p + 1) * p / 2;
            int m = 0, n = p - 1;
            int[][] A = new int[p][p];
            while ((m + n) > 0) {
                if (n > -1) {
                    A[m][n] = max;
                    m++;
                    n--;
                    max--;
                } else {
                    n = m - 2;
                    m = 0;
                    A[m][n] = max;
                    m++;
                    n--;
                    max--;
                }
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length; j++) {
                    if (A[i][j] != 0) {
                        System.out.print(A[i][j] + " ");
                    }
                }
                System.out.println("");
            }
        }
    }
}
