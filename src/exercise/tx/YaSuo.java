package exercise.tx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 * 输出描述:
 * 输出一个字符串，代表解压后的字符串。
 * 输入例子1:
 * HG[3|B[2|CA]]F
 * 输出例子1:
 * HGBCACABCACABCACAF
 */
public class YaSuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String lv = "";
        Integer lk = -1;
        Integer key1=0;
       while (key1==0){
           Map<Integer, String> signal = new HashMap<>();
           for (int i = 0; i < str.length(); i++) {
               String key = str.charAt(i) + "";
               if ("[".equals(key) || "]".equals(key)) {
                   signal.put(i, key);
               }
           }
           if(signal.size()==0){
               key1=1;
               break;
           }
           Iterator<Map.Entry<Integer, String>> entries = signal.entrySet().iterator();
           while (entries.hasNext()) {
               Map.Entry<Integer, String> v = entries.next();
               if (-1 == lk) {
                   lv = v.getValue();
                   lk = v.getKey();
               } else {
                   String cv = v.getValue();
                   Integer ck = v.getKey();
                   if ("[".equals(lv) && "]".equals(cv)) {
                       String Ccv = str.substring(lk + 1, ck);
                       String[] CcvArr = Ccv.split("\\|");
                       Integer Ccck = Integer.valueOf(CcvArr[0]);
                       String Cccv = CcvArr[1];
                       String Cresul = "";
                       for (int i = 0; i < Ccck; i++) {
                           Cresul = Cresul + Cccv;
                       }
                       String repaceStr="[" + Ccv + "]";
                       str = str.replace(repaceStr, Cresul);
                       lv = v.getValue();
                       lk = v.getKey();
                   } else {
                       lv = v.getValue();
                       lk = v.getKey();
                   }
               }
           }
       }
        System.out.println(str);
    }

}
