package exercise.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 思路：对分子式进行遍历，先判断是元素是否符合要求，在判断元素是大小写或者是数字，如果是大写，对下一位进行判断是否是小写大写或数字，确认是否是原子，并
 * 产生响应的操作，如果是小写，则也需要判断下一位为是否大写或者数组或者小写，并产生响应的操作，如果是数组，也需要对下一位进行判断是大写或者数组，并产生响应操作，
 * 遍历完成后对讲所有的原子和个数值存储到map中，再对map中的key进行排序，最后打印出来
 */
public class FenZiShi {
    public static void main(String[] strs) {
        // 输入字符串
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // 定义map
        Map<String, Integer> hh = new HashMap<String, Integer>();

        // 检查分子式是否合格
        if (s.contains("1")) {
            System.out.println("非有效的分子格式");
            return;
        }

        // 0~9数字对应十进制48－57
        // a~z字母对应的十进制97－122 十六进制61－7A
        // A~Z字母对应的十进制65－90 十六进制41－5A

        // 定义两个变量存储原子元素和个数
        String lowchar = "";
        String num = "";

        // 遍历
        for (int i = 0; i < s.length(); i++) {
            // //判断是否是括号,如果有跳出本次循环
            // if((s.charAt(i)+"").equals("(") || (s.charAt(i)+"").equals(")")){
            // continue;
            // }

            // 判断第一位字符
            if (i == 0) {
                // 判断是否大写
                if (90 <= ((int) s.charAt(i)) || ((int) s.charAt(i)) <= 65) {
                    System.out.println("非有效的分子格式");
                    return;
                } else {

                    // 判断字符下一位是否小写,是小写先存储到string中
                    if (97 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 122) {
                        lowchar = s.charAt(i) + "";
                    } else if (50 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 57) { // 判断字符下一位是否数字
                        lowchar = s.charAt(i) + "";
                    } else if (65 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 90) { // 判断字符下一位是否大写
                        hh.put(s.charAt(i) + "", 1);
                    } else {
                        System.out.println("非有效的分子格式");
                        return;
                    }
                }
            }

            // 判断最后一位之前的字符
            if (i != 0 && i < s.length() - 1) {
                // 如果i是大写字符
                if (65 <= ((int) s.charAt(i)) && ((int) s.charAt(i)) <= 90) {
                    // 判断字符下一位是否小写,是小写先存储到string中
                    if (97 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 122) {
                        lowchar = s.charAt(i) + "";
                    } else if (50 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 57) { // 判断字符下一位是否数字
                        lowchar = s.charAt(i) + "";
                    } else if (65 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 90) {
                        // 如果map中已经包含了a则值加一
                        if (hh.containsKey(s.charAt(i))) {
                            int v = hh.get(s.charAt(i)) + 1;
                            hh.remove(s.charAt(i));
                            hh.put(s.charAt(i) + "", v);
                        } else {
                            hh.put(s.charAt(i) + "", 1);
                        }
                    } else {
                        System.out.println("非有效的分子格式");
                        return;
                    }
                }
                // 如果i是数字
                if (50 <= ((int) s.charAt(i)) && ((int) s.charAt(i)) <= 57) {
                    // i下一位是大写
                    if (65 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 90) {
                        num = num + s.charAt(i) + "";
                        // 如果map中已经包含了a则值加一
                        if (hh.containsKey(lowchar)) {
                            hh.remove(lowchar);
                            hh.put(lowchar, Integer.valueOf(num));
                        } else {
                            hh.put(lowchar, Integer.valueOf(num));
                        }

                        // 清空
                        num = "";
                        lowchar = "";
                    } else if (50 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 57) {
                        num = num + s.charAt(i) + "";
                    } else {
                        System.out.println("非有效的分子格式");
                        return;
                    }
                }

                // i是小写
                if (97 <= ((int) s.charAt(i)) && ((int) s.charAt(i)) <= 122) {
                    // 下一位是大写
                    if (65 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 90) {
                        lowchar = lowchar + s.charAt(i) + "";
                        // 如果map中已经包含了a则值加一
                        if (hh.containsKey(lowchar)) {
                            hh.remove(lowchar);
                            hh.put(lowchar, 1);
                        } else {
                            hh.put(lowchar, 1);
                        }

                        // 清空
                        num = "";
                        lowchar = "";
                    } else if (50 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 57) { // 是数字存储到str中
                        lowchar = lowchar + s.charAt(i);
                    } else if (97 <= ((int) s.charAt(i + 1)) && ((int) s.charAt(i + 1)) <= 122) {
                        lowchar = lowchar + s.charAt(i);
                    } else {
                        System.out.println("非有效的分子格式");
                        return;
                    }
                }

            }
            // 对最后一位字符进行处理
            if (i == s.length() - 1) {
                // 如果i是大写字符
                if (65 <= ((int) s.charAt(i)) && ((int) s.charAt(i)) <= 90) {
                    // 如果map中已经包含了a则值加一
                    if (hh.containsKey(s.charAt(i))) {
                        int v = hh.get(s.charAt(i)) + 1;
                        hh.remove(s.charAt(i));
                        hh.put(s.charAt(i) + "", v);
                    } else {
                        hh.put(s.charAt(i) + "", 1);
                    }
                } else if (97 <= ((int) s.charAt(i)) && ((int) s.charAt(i)) <= 122) { // 如果小写
                    lowchar = lowchar + s.charAt(i) + "";
                    // 如果map中已经包含了a则值加一
                    if (hh.containsKey(lowchar)) {
                        hh.remove(lowchar);
                        hh.put(lowchar, 1);
                    } else {
                        hh.put(lowchar, 1);
                    }
                } else if (50 <= ((int) s.charAt(i)) && ((int) s.charAt(i)) <= 57) {
                    num = num + s.charAt(i) + "";
                    // 如果map中已经包含了a则值加一
                    if (hh.containsKey(lowchar)) {
                        hh.remove(lowchar);
                        hh.put(lowchar, Integer.valueOf(num));
                    } else {
                        hh.put(lowchar, Integer.valueOf(num));
                    }
                }
            }
        }

        // 排序
        String[] sr = BubbleSort(hh);
        // 打印map
        for (int i = 0; i < sr.length; i++) {
            System.out.println(sr[i] + "     " + hh.get(sr[i]));
        }
    }

    /**
     * @time 2019年11月6日上午9:28:22
     * @author lll
     * @describe BubbleSort
     */
    private static String[] BubbleSort(Map<String, Integer> hh) {
        String[] ss = new String[hh.size()];
        int m = 0;
        for (String re : hh.keySet()) {
            ss[m] = re;
            m++;
        }
        for (int i = 0; i < ss.length; i++) {
            for (int j = i; j < ss.length; j++) {
                if ((int) ss[i].charAt(0) > (int) ss[j].charAt(0)) {
                    String key = ss[i];
                    ss[i] = ss[j];
                    ss[j] = key;
                }
            }
        }
        return ss;
    }
}

