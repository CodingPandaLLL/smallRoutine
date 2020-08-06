package exercise.hw;

import java.util.HashMap;


/**
 * @author lll
 * @time 2019年12月17日下午1:36:44
 * @describe 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 * <p>
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 */
public class Fibonacci {

    public static int Fibonacci(int n) {

        //初始化，将数列存入到hashmap中
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(0, 0);
        m.put(1, 1);
        m.put(2, 1);
        for (int i = 3; i < 40; i++) {
            int v = m.get(i - 1) + m.get(i - 2);
            m.put(i, v);
        }


        //得到n项对应的值
        return m.get(n);
    }

    // 调用测试
    public static void main(String[] args) {
        System.out.println(Fibonacci(17));
        ;
    }
}
