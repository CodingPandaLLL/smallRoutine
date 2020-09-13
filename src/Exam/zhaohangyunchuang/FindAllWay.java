package Exam.zhaohangyunchuang;

import java.util.Scanner;

/*
台阶有n阶，每次可以上一阶或者两阶，一共有多少种上法
eg:输入：3
输出：3
分析：其实就是斐波那契数列
F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 */
public class FindAllWay {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int key=scanner.nextInt();
        if(key==1)
            System.out.println(1);
        if (key==2)
            System.out.println(2);
        if (key==0)
            System.out.println(0);
        int[] reult=new int[key+1];
        reult[0]=0;
        reult[1]=1;
        reult[2]=2;
        for (int i = 3; i < key+1; i++) {
            reult[i]=reult[i-1]+reult[i-2];
        }
        System.out.println(reult[key]);
    }
}
