package exercise.hw;


/**
 * 问题：在m个数中移除n个数，找出剩下的数中的最大值
 * 思路：从高位开始找，在前m-n+1位数中找到一个位置在k的最大值V，将m中k后到最后的子串作为新的m，n-1作为新的n，再次执行前面方法找出新的V，
 * 依次递归，找出所有的v,最后所有V连着一起即为最大值
 */
public class RemoveK {
    public static void main(String[] strs) {
        StringBuilder result = new StringBuilder();
        String queues = "8635273";
        int key = 5;
        QueryMax(result, queues, key);
        System.out.println(result);
    }

    // 从queues中移除key个数，确保剩下的数目是最大的
    public static void QueryMax(StringBuilder result, String queues, int key) {
        if (queues.length() < key) {
            System.out.print("illegal input");
        }
        int m = queues.length() - (key - 1);

        // leaveQ是前m-k+1位数的子串
        String leaveQ = queues.substring(0, m);
        // leaveQ是前m-k+1位数后的子串
        String queuesC1 = queues.substring(m, queues.length());
        String queuesC2 = "";

        // 找出子串中最大的值
        int flagK = 0, flagV = 0;
        for (int i = 0; i < leaveQ.length(); i++) {
            if (flagV < Integer.valueOf(leaveQ.charAt(i))) {
                flagV = Integer.valueOf(leaveQ.charAt(i));
                flagK = i;
            }
        }

        // 将最大值V连接在一起
        result = result.append(leaveQ.charAt(flagK));

        // 拼接新的子串作为m
        queuesC2 = leaveQ.substring(flagK + 1, leaveQ.length());
        String queuesC = queuesC2 + queuesC1;

        //k-1进入下一次的迭代
        key--;
        if (key > 0) {
            QueryMax(result, queuesC, key);
        }
    }
}

