package exercise.tx;

import java.util.Scanner;

/*
假定一种编码的编码范围是a ~ y的25个字母，从1位到4位的编码，如果我们把该编码按字典序排序，形成一个数组如下： a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw, yyyx,
 yyyy 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。 编写一个函数，输入是任意一个编码，输出这个编码对应的Index.
输入描述:
输入一个待编码的字符串,字符串长度小于等于100.
输出描述:
输出这个编码的index
示例1
输入
baca
输出（baca对应的十进制数事多）
输出
16331
 */
public class Code {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String code=sc.nextLine();
        int[] base=new int[4];
        for (int i = 3; i >=0; i--) {
            if(i==3){
                base[3]=1;
            }else {
                base[i]=base[i+1]*25+1;
            }

        }
        int index=0;
        for (int i = 0; i < code.length(); i++) {
            index=index+(code.charAt(i)-'a')*base[i]+1;
    }
        System.out.println(index-1);

    }
}
