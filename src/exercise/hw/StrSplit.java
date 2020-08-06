package exercise.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
   •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class StrSplit {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt(); // 输入次数
    List<String> strList = new ArrayList<String>();

    // 输入对应次数的字符串
    for (int i = 0; i < num; i++) {
      String str = sc.next();
      strList.add(str);
    }

    // 把输入的字符串进行处理
    List<String> reultList = new ArrayList<String>();
    for (int i = 0; i < strList.size(); i++) {
      String paramStr = strList.get(i);
      List<String> paramList = new ArrayList<String>();
      deal(paramList, paramStr);
      reultList.addAll(paramList);
    }
    // List<String> reultList = deal(strList);
    //打印结果
    for (int i = 0; i < reultList.size(); i++) {
      System.out.println(reultList.get(i));
    }

  }

  public static void deal(List<String> strList, String str) {
    // List<String> reultList = new ArrayList<String>();
    if (str.length() <= 8) {
      String str1 = "";
      for (int j = 0; j < 8 - str.length(); j++) {
        str1 = str1 + "0";
      }
      str = str + str1;
      strList.add(str);
    } else {
      String str2 = str.substring(0, 8);
      strList.add(str2);
      String str3 = str.substring(8, str.length());
      List<String> reultList = new ArrayList<String>();
      deal(reultList, str3);
      strList.addAll(reultList);

    }

    // return strList;
  }
}
