package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超2的子串重复
说明:长度超过2的子串
输入描述:
一组或多组长度超过2的子符串。每组占一行
输出描述:
如果符合要求输出：OK，否则输出NG
 */
public class CheckPwd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String pwd = scanner.nextLine();
            int flag = 0;
            //检查长度是否合格
            if (pwd.length() <= 8) {
                flag = 1;
            }
            //检查包含字符是否合格
            int x = 0, y = 0, z = 0, w = 0;
            for (int i = 0; i < pwd.length(); i++) {
                // 0~9数字对应十进制48－57
                // a~z字母对应的十进制97－122 十六进制61－7A
                // A~Z字母对应的十进制65－90 十六进制41－5A
                int v = (int) pwd.charAt(i);
                if (v <= 57 && v >= 48) {
                    x = 1;
                } else if ((v <= 122 && v >= 97)) {
                    y = 1;
                } else if ((v <= 90 && v >= 65)) {
                    z = 1;
                } else {
                    w = 1;
                }
            }
            if ((x + y + z + w) < 3) {
                flag = 1;
            }
            //检查是否包含子串
            List<String> resul = new ArrayList<String>();
            for (int i = 0; i < pwd.length() - 2; i++) {
                String cresul = pwd.substring(i, i + 3);
                resul.add(cresul);
            }
            for (int i = 0; i < resul.size(); i++) {
                int k = 0;
                for (int j = 0; j < resul.size(); j++) {
                    if (resul.get(i).equals(resul.get(j))) {
                        k++;
                    }
                }
                if (k > 1) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                System.out.println("NG");
            } else {
                System.out.println("OK");
            }

        }

    }
}
