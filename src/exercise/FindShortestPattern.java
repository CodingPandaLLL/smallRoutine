package exercise;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目： 给定文本text和待匹配字符串pattern，二者只包含小写字母，并且不为空。
 * 在text中找出匹配的pattern的最短字符串。匹配值按序包含pattern，但不要求pattern连续。
 * 如text为abbacxbcatttcd，pattern为cbc，满足条件的是cxbc
 */
public class FindShortestPattern {
    public static void main(String[] strs) {
        // 输入text和pattern
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();

        /**
         * 如果本题加大难度，说可以输入大小写，但查找时大小写均可以匹配的话
         * 只需要在拿到字符串后统一改为大写或者小写即可
         * text.toLowerCase();  转小写
         * text.toUpperCase();  转大写
         */

        // 定义map存储pattern各个字符在text中的位置和值
        Map<Integer, String> location = new HashMap<Integer, String>();

        // 定义m标记pattern中的字符找到text对字符的位置，以便下次从m位置查找
        int m = 0;
        for (int i = 0; i < pattern.length(); i++) {
            for (int j = m; j < text.length(); j++) {
                if (pattern.charAt(i) == text.charAt(j)) {
                    location.put(j, text.charAt(j) + "");
                    m = j;

                    // 找到text中对应位置后跳出本次循环查找下一个pattern的字符
                    break;
                }
            }
        }

        //打印出map
        for (int key : location.keySet()) {
            System.out.println(key + "   " + location.get(key));
        }
    }
}
