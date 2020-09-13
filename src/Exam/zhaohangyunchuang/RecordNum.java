package Exam.zhaohangyunchuang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
找出数组中那个数只出现过一次
eg:
输入[3,3,9,0,9]
输出：0
 */
public class RecordNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        String[] intArr=str.substring(1,str.length()-1).split(",");
        Map<Integer,Integer> result=new HashMap<>();
        for (int i = 0; i <intArr.length; i++) {
            if(result.containsKey(Integer.valueOf(intArr[i]))){


                int v=result.get(Integer.valueOf(intArr[i]));
                v++;
                result.put(Integer.valueOf(intArr[i]),v);
            }else{
                result.put(Integer.valueOf(intArr[i]),1);
            }
        }
        for(Integer k:result.keySet()){
            int v=result.get(k);
            if(v==1){
                System.out.println(k);
            }
        }

    }
}
