package exercise.tx;

import java.util.Scanner;

/**
 * 输入n，输出方阵，
 * n=5时如下
 * 0   0   0   0   5
 * 0   0   0   6   4
 * 0   0   7   14  3
 * 0   8   15  13  2
 * 9   10  11  12  1
 * <p>
 * n=3时如下
 * 0   0   3
 * 0   4   2
 * 5   6   1
 */
public class SquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x=n;
        int[][] flag = new int[n][n];
        int[][] value = new int[n][n];
//        //初始化校验
        for (int i = 0; i < n; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                if ((i + j) >= n - 1) {
                    flag[i][j] = 0; //不能被赋值
                } else {
                    flag[i][j] = 1; //可以赋值
                }
            }
        }
        //开始遍历(for循环中不加遍历条件，遍历由自己控制)
        int key = 0;
        int direct = 1; //遍历的方向1向上2斜向下3向右
        int i=n-1;
        int j=3;
        while (i>-1){
                if (direct == 1) {
                    if (flag[i][j] == 0) {
                        key++;
                        value[i][j] = key;
                        flag[i][j] = 1;
                        if (j > 0 && flag[i--][j] == 0) {
                            i--;
                        } else {
                            i--;
                            j++;
                            direct = 2;
                        }
                    } else {
                        break;
                    }
                } else if (direct == 2) {
                    if (flag[i][j] == 0) {
                        key++;
                        value[i][j] = key;
                        flag[i][j] = 1;
                        if (i > 0 && j<n-1 && flag[i--][j++] == 0) {
                            i--;
                            j++;
                        } else {
                            i++;
                            direct = 3;
                        }
                    } else {
                        break;
                    }
                } else if (direct == 3) {
                    if (flag[i][j] == 0) {
                        key++;
                        value[i][j] = key;
                        flag[i][j] = 1;
                        if (i < n - 1 && flag[i++][j] == 0) {
                            i++;
                        } else {
                            i--;
                            direct = 1;
                        }
                    } else {
                        break;
                    }
        }
        }
        //打印结果
        for (int k = 0; k < value.length; k++) {
            System.out.println("");
            for (int m = 0; m < value[i].length; m++) {
                System.out.print(value[k][m]);
            }
        }
    }
}
