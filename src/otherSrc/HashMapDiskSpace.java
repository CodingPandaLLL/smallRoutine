package otherSrc;

import java.util.HashMap;

public class HashMapDiskSpace {
    public static void main(String[] args) {
        Integer a = 1;
        long start = 0;
        long end = 0;
        // 先垃圾回收
        System.gc();
        start = Runtime.getRuntime().freeMemory();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(100, 100);
        // 快要计算的时,再清理一次
        System.gc();
        end = Runtime.getRuntime().freeMemory();
        System.out.println("一个HashMap对象占内存:" + (end - start));
    }
}
