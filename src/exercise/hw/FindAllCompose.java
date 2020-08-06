package exercise.hw;


import java.util.Set;
import java.util.TreeSet;

/**
 * 问题：三个由1-9组成且各位均不相同的三位数A,B,C，找出所有A+B=C的组合
 * 例如：A=127 B=368 C=495
 * 思路：六重循环找出两个位数各不相同的三位数，将两个三位数相加，得到第三个三位数
 * 判断第三位数是否大于999，如果大于则不满足条件，如果不大于，将所有三个三位数以字符存到Set中，判断Set的长度
 * 如果Set长度等于9则符合条件
 */
public class FindAllCompose {
    public static void main(String[] strs) {

        int A = 0, B = 0, C = 0;

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (i == j) {
                    continue;
                }
                for (int s = 1; s < 9; s++) {
                    if (s == i || s == j) {
                        continue;
                    }
                    // 第一个三位数A
                    A = i * 100 + j * 10 + s;

                    for (int k = 1; k < 9; k++) {
                        if (k == s || k == j || k == i) {
                            continue;
                        }
                        for (int n = 1; n < 9; n++) {
                            if (n == s || n == j || n == i || n == k) {
                                continue;
                            }
                            for (int r = 1; r < 9; r++) {
                                if (r == s || r == j || r == i || r == k
                                        || r == n) {
                                    continue;
                                }
                                // 第二个三位数B
                                B = k * 100 + n * 10 + r;
                                if (A + B > 1000) {
                                    continue;
                                }

                                // 第三个三位数C
                                C = A + B;

                                // 将ABC合并为字符串存在Set中
                                String sun = (A + "" + B + "" + C + "");
                                // System.out.println("A="+A+"B="+B+"C="+C);
                                Set exam = new TreeSet<>();
                                for (int m = 0; m < sun.length(); m++) {
                                    exam.add(sun.charAt(m));
                                }
                                // 如果Set长度为9则符合条件，因为Set保存的数据不能重复
                                if (exam.size() == 9 && !exam.contains('0')) {
                                    System.out.println("A=" + A + "B=" + B
                                            + "C=" + C);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
