package  exercise;
import java.util.Scanner;

/*
开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
输入：
合法坐标为A(或者D或者W或者S) + 数字（两位以内）
坐标之间以;分隔。
非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

输入描述:
一行字符串
输出描述:
最终坐标，以,分隔
 */
public class Coordinate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){

        }
        String N = scanner.nextLine();
        int x = 0, y = 0;
        String[] nArr = N.split(";");
        for (int i = 0; i < nArr.length; i++) {
            if ("".equals(nArr[i])) {
                continue;
            }
            if( !nArr[i].startsWith("A") && !nArr[i].startsWith("D") && !nArr[i].startsWith("W") && !nArr[i].startsWith("S")){
                continue;
            }
            String head = nArr[i].substring(0, 1);
            try {
                int v = Integer.valueOf(nArr[i].substring(1, nArr[i].length()));
                if ("A".equals(head)) {
                    x = x - v;
                }
                if ("D".equals(head)) {
                    x = x + v;
                }
                if ("W".equals(head)) {
                    y = y + v;
                }
                if ("S".equals(head)) {
                    y = y - v;
                }
            } catch (Exception e) {
                continue;
            }
        }
        System.out.println(x+","+y);
    }
}

