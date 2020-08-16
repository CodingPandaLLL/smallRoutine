package exercise.tx;

import java.util.Scanner;

/**
 * 输入一个数字n和一个字符串，n表示该字符串长度。字符串只有0和1，0和1挨着就消除，00和11保留，无限消除直到得出最后结果，并输出结果字符串的长度
 * 输入 4 1010
 * 输出0
 */
public class ClearZeroOne {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count= Integer.valueOf(scanner.nextLine());
        String str1=scanner.nextLine();
        StringBuilder str=new StringBuilder(str1);
        if(1==count ||0==count){
            System.out.println(count);
        }else{
            for (int i = 0; i < str.length(); i++) {
                if(i!=str.length()-1){
                    int key = Integer.valueOf(str.charAt(i)+"");
                    int key1 = Integer.valueOf(str.charAt(i+1)+"");
                    if(key!=key1){
                        str.replace(i,i+1,"");
                        str.replace(i,i+1,"");
                        i=-1;
                    }
                }
            }
        }
        System.out.println(str.length());
    }
}
