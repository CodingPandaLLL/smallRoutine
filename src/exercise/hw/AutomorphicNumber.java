package exercise.hw;

import java.util.Scanner;

/*
自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
接口说明
功能: 求出n以内的自守数的个数
输入参数：
int n
返回值：
n以内自守数的数量。
public static int CalcAutomorphicNumbers( int n) {
        return 0
}
本题有多组输入数据，请使用while(cin>>)等方式处理
输入描述:
int型整数
输出描述:
n以内自守数的数量。
示例1
输入
2000
输出
8
 */
public class AutomorphicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int result = 0;
            for (int i = 0; i <= n; i++) {
                int il=(i+"").length();
                String ii=i*i+"";
                int sp=Integer.valueOf(ii.substring(ii.length()-il,ii.length()));
                if(i==sp){
                    //System.out.println(i);
                    result++;
                }
            }
            System.out.println(result);

        }
    }
}
