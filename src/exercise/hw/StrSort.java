package exercise.hw;

import java.util.Scanner;

/*
将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。 如：输入“I am a student”，输出“tneduts a ma I”。
 */
public class StrSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        for (int i=input.length()-1;i>-1;i--) {
            System.out.print(input.charAt(i));
        }
    }
}
