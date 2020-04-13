package exercise;


/**
 * @time 2019年12月17日下午1:36:44
 * @author lll
 * @describe 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * int x = 4;
 * //原码：00000000 00000000 00000000 00000100
 * //反码：00000000 00000000 00000000 00000100
 * //补码：00000000 00000000 00000000 00000100
 * System.out.println(Integer.toBinaryString(x));
 * //输出结果：100
 *
 * int y = -4;
 * //原码：10000000 00000000 00000000 00000100
 * //反码：11111111 11111111 11111111 11111011
 * //补码：11111111 11111111 11111111 11111100
 * System.out.println(Integer.toBinaryString(y));
 * //输出结果：11111111111111111111111111111100
 */
public class BuMa {

    public static int NumberOf1(int n) {
        //整数获取其二进制数，负数获取其补码
        String s = Integer.toBinaryString(n);

        //遍历s，获取1的个数key
        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                key++;
            }
        }
        return key;
    }

    // 调用测试
    public static void main(String[] args) {
        System.out.println(NumberOf1(-4));;
    }
}
