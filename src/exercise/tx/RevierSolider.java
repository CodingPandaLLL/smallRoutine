package exercise.tx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,即可以看作是[0,L]的一条数轴。
 * 这款竞技游戏当中有n个可以提供视野的道具−真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。
 * 输入描述:
 * 输入包括n+1行。
 * 第一行包括两个正整数n和L(1<=n<=105,1<=L<=109)
 * 接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=109),表示第i个真视守卫覆盖的区间。
 * 输出描述:
 * 一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
 * 输入例子1:
 * 4 6
 * 3 6
 * 2 4
 * 0 2
 * 4 7
 * 输出例子1:
 * 3
 */
public class RevierSolider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] A = (sc.nextLine()).split(" ");
        int A1 = Integer.valueOf(A[0]); //守卫个数
        int A2 = Integer.valueOf(A[1]); //河长度
        List<Integer[]> A2l = new ArrayList<Integer[]>();
        List<Integer[]> result = new ArrayList<Integer[]>();
        int key = 0;
        for (int i = 0; i < A1; i++) {
            String[] A2ll = (sc.nextLine()).split(" ");
            Integer[] A2lll = new Integer[]{Integer.valueOf(A2ll[0]), Integer.valueOf(A2ll[1])};
            A2l.add(A2lll);
        }
        int flag=0;
        Here:
        for (int i = 0; ; i++) {
            int v0 = A2l.get(i)[0];
            int v1 = A2l.get(i)[1];
            if (result.size() == 0 && v0 == 0) {
                result.add(A2l.get(i));
            } else {
                for (int j = 0; j < result.size(); j++) {
                    flag++;
                    if(flag==A1*A1*A1){
                        break Here;
                    }
                    int r0 = result.get(j)[0];
                    int r1 = result.get(j)[1];
                    if (r0 == v0 && r1 > v1) {
                        result.set(j, A2l.get(i));
                    } else if (r1 >= v0 && v1 <= A2 && !result.contains(A2l.get(i))) {
                        result.add(A2l.get(i));
                        break ;
                    }
                }
            }
            if(i==A2l.size()-1){
                if(result.size() == 0){
                   break ;
                }
                i=-1;
            }
        }

        if(result.size()>1){
            int r0 = result.get(0)[0];
            int r1 = result.get(result.size()-1)[1];
            if(r1-r0>=A1){
                System.out.println(result.size());
            }else{
                System.out.println(-1);
            }
        }else {
            System.out.println(-1);
        }
    }
}
