package exercise.hw;

import java.util.Scanner;

/*
正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数\
eg 5 7 35
 */
public class MinCommonMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int k = A;
        if (A < B) {
            k = B;
        }
        int result = 1;
        while (k!=-1){
            if (k%B==0 && k%A==0){
                result=k;
                k=-1;
            }else {
                k++;
            }
        }

        System.out.println(result);
    }

}

