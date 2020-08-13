package exercise.hw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 * 数据范围小于1e6
 * eg -12 -1 -3    输出 3  0.0
 */
public class RecordNegative {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> listInput=new ArrayList<Integer>();
        while (scanner.hasNextInt()){
            listInput.add(scanner.nextInt());
        }
        int negativeCount=0;
        int postiveSum=0;
        int postiveCount=0;
        for (int i = 0; i < listInput.size(); i++) {
            if(listInput.get(i)<0){
                negativeCount++;
            }else{
                postiveSum=postiveSum+listInput.get(i);
                postiveCount++;
            }
        }
        BigDecimal postiveSum1=new BigDecimal(postiveSum);
        BigDecimal postiveCount1=new BigDecimal(postiveCount);
        BigDecimal averagePostive=new BigDecimal(0.0);
        if (postiveCount!=0){
             averagePostive=postiveSum1.divide(postiveCount1,1, BigDecimal.ROUND_HALF_UP);
        }
        System.out.println(negativeCount);
        System.out.println(averagePostive);
    }
}
