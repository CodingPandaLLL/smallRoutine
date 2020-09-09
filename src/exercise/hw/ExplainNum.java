package exercise.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
题目描述:表示数组
将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
public static String MarkNum(String pInStr)
{
    return null;
}
注意：输入数据可能有多行
输入描述:
输入一个字符串

输出描述:
字符中所有出现的数字前后加上符号“*”，其他字符保持不变

示例1
输入
Jkdi234klowe90a3
输出
Jkdi*234*klowe*90*a*3*
 */
public class ExplainNum {
    public static String MarkNum(String pInStr) {
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < pInStr.length(); i++) {
            strList.add(String.valueOf(pInStr.charAt(i)));
        }
        List<String> strList1 = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            int c = strList.get(i).charAt(0);
            if (i == strList.size() - 1) {
                if (48 <= c && 57 >= c) {
                    strList1.add(strList.get(i));
                    strList1.add("*");
                }else {
                    strList1.add(strList.get(i));
                }
            } else if(i==0) {
                if (48 <= c && 57 >= c) {
                    int c1 = strList.get(i + 1).charAt(0);
                    if (48 <= c1 && 57 >= c1) {
                        strList1.add("*");
                        strList1.add(strList.get(i));
                    } else {
                        strList1.add("*");
                        strList1.add(strList.get(i));
                        strList1.add("*");
                    }
                } else {
                    int c1 = strList.get(i + 1).charAt(0);
                    if (48 <= c1 && 57 >= c1) {
                        strList1.add(strList.get(i));
                        strList1.add("*");
                    } else {
                        strList1.add(strList.get(i));
                    }
                }
            }else{
                if (48 <= c && 57 >= c) {
                    int c1 = strList.get(i + 1).charAt(0);
                    if (48 <= c1 && 57 >= c1) {
                        strList1.add(strList.get(i));
                    } else {
                        strList1.add(strList.get(i));
                        strList1.add("*");
                    }
                } else {
                    int c1 = strList.get(i + 1).charAt(0);
                    if (48 <= c1 && 57 >= c1) {
                        strList1.add(strList.get(i));
                        strList1.add("*");
                    } else {
                        strList1.add(strList.get(i));
                    }
                }
            }
        }
        String result="";
        for (int i = 0; i <strList1.size(); i++) {
            result = result + strList1.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(MarkNum(str));
        }
    }
}
