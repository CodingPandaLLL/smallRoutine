import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*

 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] Arr = line.split(" ");
        for (int i = 0; i < Arr.length; i++) {
            List<Integer> chaArr = new ArrayList<>();
            HashMap<Integer, String> kv = new HashMap<Integer, String>();
            String redult="";
            for (int j = 0; j < Arr[i].length(); j++) {
                // 0~9数字对应十进制48－57
                // a~z字母对应的十进制97－122 十六进制61－7A
                // A~Z字母对应的十进制65－90 十六进制41－5A
                int key = (int) Arr[i].charAt(j);
                if (key >= 65 && key <= 90) {
                    chaArr.add(key);
                } else if (key >= 97 && key <= 122) {
                    chaArr.add(key);
                } else {
                    kv.put(j,Arr[i].charAt(j)+"");
                }
                List<Integer> sortList =bubble(chaArr);
                String resultC ="";
                for (int k = 0; k <sortList.size()+kv.size() ; k++) {
                    if(kv.containsKey(k)){
                        resultC=resultC+kv.get(k);
                    }else{
                        resultC
                    }

                }
            }
        }
    }

    public static List<Integer> bubble(List<Integer> intArr) {
        for (int i = 0; i < intArr.size(); i++) {
            // 找出本次中最小的值
            for (int j = i; j < intArr.size(); j++) {
                if (intArr.get(j) < intArr.get(i)) {
                    // 比较交换值
                    int k = intArr.get(i);
                    intArr.set(i, intArr.get(j));
                    intArr.set(j,k);
                }
            }
        }
        return intArr;
    }
}
