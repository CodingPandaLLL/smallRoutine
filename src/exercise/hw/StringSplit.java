package exercise.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
首先输入一个整数，为要输入的字符串个数。
例如：
输入：2
abc
12345789

输出：abc00000
12345678
90000000
 */
public class StringSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       while (scanner.hasNext()){
           int count = Integer.valueOf(scanner.nextLine());
           List<String> listString = new ArrayList<String>();
           for (int i = 0; i < count; i++) {
               listString.add(scanner.nextLine());
           }
           for (int i = 0; i < count; i++) {
               String str = listString.get(i);
               int eight = str.length() / 8 + 1;
               if (eight == 1) {
                   int key = 8 - str.length();
                   String zero = "";
                   for (int k = 0; k < key; k++) {
                       zero = zero + "0";
                   }
                   System.out.println(str + zero);
               } else {
                   for (int j = 0; j < eight; j++) {
                       if (j == eight - 1) {
                           String str1 = str.substring((j * 8), str.length());
                           if (!str1.equals("")) {
                               if (str1.length() == 8) {
                                   System.out.println(str1);
                               } else {
                                   int key = 8 - str1.length();
                                   String zero = "";
                                   for (int k = 0; k < key; k++) {
                                       zero = zero + "0";
                                   }
                                   System.out.println(str1 + zero);
                               }
                           }
                       } else {
                           System.out.println(str.substring((j * 8), (j + 1) * 8));
                       }
                   }
               }
           }
       }
    }
}
