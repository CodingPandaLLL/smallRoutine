package exercise;

import java.util.*;

/*
数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 */
public class AddIndexSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.nextLine();
        List<String> paramList = new ArrayList<String>();
        for (int i = 0; i < Integer.valueOf(X); i++) {
            String cparam = sc.nextLine();
            paramList.add(cparam);
        }
        //数据初始化,将key和value分别存入到两个不同的有序List中
        List<Integer> keyList = new ArrayList<Integer>();
        List<Integer> valueList = new ArrayList<Integer>();
        for (int i = 0; i < paramList.size(); i++) {
            String[] cparamArr = paramList.get(i).split(" ");
            keyList.add(Integer.valueOf(cparamArr[0]));
            valueList.add(Integer.valueOf(cparamArr[1]));
        }
        //数据清洗，对存放键值List遍历，并按照键值相同的value加起来存放在hashmap中
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < keyList.size(); i++) {
            if (resultMap.containsKey(keyList.get(i))) {
                int value = resultMap.get(keyList.get(i));
                value = value + valueList.get(i);
                resultMap.put(keyList.get(i), value);
            } else {
                resultMap.put(keyList.get(i), valueList.get(i));
            }
        }

        //将map中的key存放在lst中
        List<Integer> lst = new ArrayList<Integer>();
        for (Integer key : resultMap.keySet()) {
            lst.add(key);
        }
        //对lst升序进行排序
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (lst.get(i) < lst.get(j)) {
                    int k = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, k);
                }
            }
        }
        //打印结果
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i) + " " + resultMap.get(lst.get(i)));
        }
    }


}


