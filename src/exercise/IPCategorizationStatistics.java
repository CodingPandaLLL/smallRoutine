package exercise;

import java.util.Scanner;


/*
请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
所有的IP地址划分为 A,B,C,D,E五类
A类地址1.0.0.0~126.255.255.255;
B类地址128.0.0.0~191.255.255.255;
C类地址192.0.0.0~223.255.255.255;
D类地址224.0.0.0~239.255.255.255；
E类地址240.0.0.0~255.255.255.255
私网IP范围是：
10.0.0.0～10.255.255.255
172.16.0.0～172.31.255.255
192.168.0.0～192.168.255.255
子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
注意二进制下全是1或者全是0均为非法
注意：
1. 类似于【0.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
2. 私有IP地址和A,B,C,D,E类地址是不冲突的
输入描述:
多行字符串。每行一个IP地址和掩码，用~隔开。
输出描述:
统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 */
public class IPCategorizationStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = 0, bNum = 0, cNum = 0, dNum = 0, eNum = 0, error = 0, pNum = 0;
        while (sc.hasNextLine()) {


            String inputStr = sc.nextLine();
            if ("".equals(inputStr)) {
                break;
            }
            String[] StrArr = inputStr.split("~");
            String Ip = StrArr[0];
            String netMask = StrArr[1];


            String[] IpArr = Ip.split("[.]");
            int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, p = 0;
            //分析IP
            //判断基本格式
            int m = 0;
            for (int i = 0; i < IpArr.length; i++) {
                if ("".equals(IpArr[i])) {
                    err++;
                    m++;
                    break;
                }
            }
            if (m == 0) {
                for (int i = 0; i < IpArr.length; i++) {
                    int v = v = Integer.valueOf(IpArr[i]);
                    ;
                    if (i == 0) {
                        if (v == 0) {
                            break;
                        }
                        if (1 <= v && v <= 126) {
                            a++;
                            if (10 == v) {
                                p++;
                            }
                        }
                        if (128 <= v && v <= 191) {
                            b++;
                        }
                        if (192 <= v && v <= 223) {
                            c++;
                        }
                        if (224 <= v && v <= 239) {
                            d++;
                        }
                        if (240 <= v && v <= 255) {
                            e++;
                        }
                    }

                    if (v < 0 || v > 255) {
                        err++;
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        e = 0;
                        p = 0;
                        break;
                    }
                }
            }
            //判断私有IP
            if (4 == IpArr.length) {
                if (172 == Integer.valueOf(IpArr[0]) && 16 <= Integer.valueOf(IpArr[1]) && 31 >= Integer.valueOf(IpArr[1]) && 0 <= Integer.valueOf(IpArr[3]) && 255 >= Integer.valueOf(IpArr[3]) && 0 <= Integer.valueOf(IpArr[2]) && 255 >= Integer.valueOf(IpArr[2])) {
                    p++;
                }
                if (192 == Integer.valueOf(IpArr[0]) && 168 == Integer.valueOf(IpArr[1]) && 0 <= Integer.valueOf(IpArr[3]) && 255 >= Integer.valueOf(IpArr[3]) && 0 <= Integer.valueOf(IpArr[2]) && 255 >= Integer.valueOf(IpArr[2])) {
                    p++;
                }
            }


            //分析掩码
            String[] netMaskArr = netMask.split("[.]");
            String netMaskTwo = "";
            for (int i = 0; i < netMaskArr.length; i++) {
                String cnm = Integer.toBinaryString(Integer.valueOf(netMaskArr[i]));
                //保存掩码的二进制为8位
                if (cnm.length() < 8) {
                    String l = "";
                    for (int j = 0; j < 8 - cnm.length(); j++) {
                        l = l + "0";
                    }
                    cnm = l + cnm;
                }
                netMaskTwo = netMaskTwo + cnm;
            }
            int key = 0;
            for (int i = 0; i < netMaskTwo.length(); i++) {
                if (Integer.valueOf(netMaskTwo.charAt(i) + "") == 0) {
                    key = 1;
                    continue;
                }
                if (Integer.valueOf(netMaskTwo.charAt(i) + "") == 1 && key == 1) {
                    key = 2;
                    break;
                }
            }
            //key为2表示为错误掩码
            if (key == 2 || key == 0) {
                err++;
            }

            if (err != 0) {
                error++;
            } else {
                aNum = aNum + a;
                bNum = bNum + b;
                cNum = cNum + c;
                dNum = dNum + d;
                eNum = eNum + e;
                pNum = pNum + p;
            }

//            if(err!=0){
//                System.out.println(inputStr+" "+"error");
//            }
//            if(a!=0){
//                System.out.println(inputStr+" "+"aNum");
//            }
//            if(b!=0){
//                System.out.println(inputStr+" "+"bNum");
//            }
//            if(c!=0){
//                System.out.println(inputStr+" "+"cNum");
//            }
//            if(d!=0){
//                System.out.println(inputStr+" "+"dNum");
//            }
//            if(e!=0){
//                System.out.println(inputStr+" "+"eNum");
//            }


        }
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + error + " " + pNum);
    }
}

