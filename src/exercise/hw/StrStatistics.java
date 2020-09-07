package exercise.hw;

import java.util.*;

/*
题目描述
如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
实现以下接口：
输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出
清空目前的统计结果，重新统计
调用者会保证：
输入的字符串以‘\0’结尾。

输入描述:
输入一串字符。
输出描述:
对字符中的
各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
示例1
输入
复制aadddccddc
输出
复制dca
 */
public class StrStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.nextLine();
            //输入的字符存放到hashMap中
            Map<String, String> saveInput = new HashMap<String, String>();
            for (int i = 0; i < input.length(); i++) {
                /**
                 * ASCII码
                 * A~Z 65~90
                 * a~z 97~122
                 * 0-9 48~57
                 */
                int key = input.charAt(i);
                if (65 <= key && 90 >= key) {
                    String cInput = String.valueOf(input.charAt(i));
                    if (saveInput.containsKey(cInput)) {
                        String v = saveInput.get(cInput);
                        Integer v1 = Integer.valueOf(v.substring(1, v.length()));
                        String v0 = v.substring(0, 1);
                        v1++;
                        saveInput.put(cInput, v0 + v1);
                    } else {
                        saveInput.put(cInput, cInput + "1");
                    }
                }
                if (97 <= key && 122 >= key) {
                    String cInput = String.valueOf(input.charAt(i));
                    if (saveInput.containsKey(cInput)) {
                        String v = saveInput.get(cInput);
                        Integer v1 = Integer.valueOf(v.substring(1, v.length()));
                        String v0 = v.substring(0, 1);
                        v1++;
                        saveInput.put(cInput, v0 + v1);
                    } else {
                        saveInput.put(cInput, cInput + "1");
                    }
                }
                if (48 <= key && 57 >= key) {
                    String cInput = String.valueOf(input.charAt(i));
                    if (saveInput.containsKey(cInput)) {
                        String v = saveInput.get(cInput);
                        Integer v1 = Integer.valueOf(v.substring(1, v.length()));
                        String v0 = v.substring(0, 1);
                        v1++;
                        saveInput.put(cInput, v0 + v1);
                    } else {
                        saveInput.put(cInput, cInput + "1");
                    }
                }
            }
            List<String> InputCNum = new ArrayList<String>();
            for (Map.Entry<String, String> v : saveInput.entrySet()) {
                InputCNum.add(v.getValue());
            }
            InputCNum = sort(InputCNum);
            for (int i = 0; i < InputCNum.size() ; i++) {
                System.out.print(InputCNum.get(i).substring(0,1));
            }
            System.out.println("");
        }
        //System.out.println(InputCNum);

    }

    //排序
    static List<String> sort(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                String i0 = list.get(i).substring(0, 1);
                Integer i1 = Integer.valueOf(list.get(i).substring(1, list.get(i).length()));
                String j0 = list.get(j).substring(0, 1);
                Integer j1 = Integer.valueOf(list.get(j).substring(1, list.get(j).length()));
                if (i1 < j1) {
                    int k = i1;
                    list.set(i, j0 + j1);
                    list.set(j, i0 + k);
                }else if(i1 == j1 && i0.charAt(0)>j0.charAt(0)){
                    int k = i1;
                    list.set(i, j0 + j1);
                    list.set(j, i0 + k);
                }
            }
        }
        return list;
    }
}
