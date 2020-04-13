package exercise;

/*
二、八、十、十六进制相互转换
 */
public class JinZhiZhuanHuan {

    public static void main(String[] args) {
        /*
          二进制——》八进制
         */
        System.out.println("二进制——》八进制:方法一");
        String str28 = "1111101110011";
        System.out.println(Integer.toOctalString(Integer.parseInt(str28, 2)));



        /*
          八进制——》二进制
         */
        System.out.println("八进制——》二进制:方法一");
        String str82 = "17563";
        System.out.println(Integer.toBinaryString(Integer.valueOf(str82, 8)));




        /*
          二进制——》十六进制
         */
        System.out.println("二进制——》十六进制:方法一");
        String str216 = "1111101110011";
        System.out.println(Integer.toHexString(Integer.parseInt(str216, 2)));




        /*
          十六进制——》二进制
         */
        System.out.println("十六进制——》二进制:方法一");
        String str162 = "1f73";
        System.out.println(Integer.toBinaryString(Integer.valueOf(str162, 16)));
        ;




        /*
          二进制——》十进制
         */
        System.out.println("二进制——》十进制:方法一");
        String key = "1111101110011";
        //把2进制字符串key，转成10进制keys
        int keys = Integer.parseInt(key, 2);//数字2代表进制，可以是各种进制，转换成10进制
        System.out.println(keys);




        /*
          十进制——》二进制
         */
        System.out.println("十进制——》二进制:方法一");
        int num = 16;
        String a = "";//用字符串拼接
        while (num != 0) {//利用十进制转二进制除2法
            a = num % 2 + a;
            num = num / 2;
        }
        System.out.println(a);

        System.out.println("十进制——》二进制:方法二");
        int num102 = 8051;
        System.out.println(Integer.toBinaryString(num102));




        /*
          八进制——》十六进制
         */
        System.out.println("八进制——》十六进制:方法一");
        String str816 = "17563";
        System.out.println(Integer.toHexString(Integer.valueOf(str816, 8)));
        ;



        /*
          十六进制——》八进制
         */
        System.out.println("十六进制——》八进制:方法一");
        String str168 = "1f73";
        System.out.println(Integer.toOctalString(Integer.valueOf(str168, 16)));




        /*
           十进制——》八进制
         */
        System.out.println("十进制——》八进制:方法一");
        int str108 = 8051;
        System.out.println(Integer.toOctalString(str108));




        /*
          八进制——》十进制
         */
        System.out.println("八进制——》十进制:方法一");
        String key810 = "17563";
        //把2进制字符串key，转成10进制keys
        System.out.println(Integer.parseInt(key810, 8));


        /*
          十六进制——》十进制
         */
        System.out.println("十六进制——》十进制:方法一");
        String strHex3 = "1f73";   //定义一个十六进制值
        int valueTen2 = Integer.parseInt(strHex3, 16);   //将十六进制转化成十进制
        int valueHex = 0x00001322;   //可以在声明十进制时，自动完成十六进制到十进制的转换
        System.out.println(valueTen2);


        /*
          十进制——》十六进制
         */
        System.out.println("十进制——》十六进制:方法一");
        int valueTen = 8051;
        String strHex = Integer.toHexString(valueTen);   //将其转换为十六进制并输出
        String strHex2 = String.format("%08x", valueTen);   //将十六进制格式化输出
        System.out.println(strHex2);


    }

}

