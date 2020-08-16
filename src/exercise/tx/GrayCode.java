package exercise.tx;

import java.util.*;

/*
在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
给定一个整数n，请返回n位的格雷码，顺序为从0开始。
测试样例：
1
返回：["0","1"]
 */
public class GrayCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String resul="";
        String[] resulArr=getGray(n);
        for (int i = 0; i < resulArr.length; i++) {
            if(i==resulArr.length-1){
                resul=resul+resulArr[i];
            }else{
                resul=resul+resulArr[i]+",";
            }
        }
        System.out.println(resul);
    }
    public static String[] getGray(int n) {
        if (n == 1) {
            return new String[]{"0", "1"};
        } else {
            String[] lastGray = getGray(n - 1);

            List<String> returnSet = new ArrayList<>();
            for (int i = 0; i < lastGray.length; i++) {
                String v1="0" + lastGray[i];
                if(!returnSet.contains(v1)){
                    returnSet.add(v1);
                }
                String v2="1" + lastGray[i];
                if(!returnSet.contains(v2)){
                    returnSet.add(v2);
                }
                String v3=lastGray[i]+"0";
                if(!returnSet.contains(v3)){
                    returnSet.add(v3);
                }
                String v4=lastGray[i]+"1";
                if(!returnSet.contains(v1)){
                    returnSet.add(v4);
                }
            }
            String[] returnStr= returnSet.toArray(new String[0]);
            return returnStr;
        }
    }
}
