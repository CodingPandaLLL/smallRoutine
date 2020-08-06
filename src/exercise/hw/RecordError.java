package exercise.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理：
1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
3、 输入的文件可能带路径，记录文件名称不能带路径。
输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
输出描述:
将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 */
public class RecordError {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> infoList = new ArrayList<String>();
        List<Integer> numList = new ArrayList<Integer>();
        while (scanner.hasNextLine()) {
            String errorInfo = scanner.nextLine();
            if ("".equals(errorInfo)) {
                break;
            }
            //处理errorInfo
            String path = errorInfo.split(" ")[0];
            String num = errorInfo.split(" ")[1];
            String[] pathArr = path.split("\\\\");
            String name = pathArr[pathArr.length - 1];
            if (name.length() > 16) {
                name = name.substring(name.length() - 16, name.length());
            }
            errorInfo = name + " " + num;
            if (!infoList.contains(errorInfo)) {
                infoList.add(errorInfo);
                numList.add(1);
            } else {
                //重复的数据加一
                for (int i = 0; i < infoList.size(); i++) {
                    if (errorInfo.equals(infoList.get(i))) {
                        numList.set(i, numList.get(i) + 1);
                    }
                }
            }
        }
        if (infoList.size() <= 8) {
            for (int i = 0; i < infoList.size(); i++) {
                System.out.println(infoList.get(i) + " " + numList.get(i));
            }
        } else {
            for (int i = infoList.size() - 8; i < infoList.size(); i++) {
                System.out.println(infoList.get(i) + " " + numList.get(i));
            }
        }
    }
}
