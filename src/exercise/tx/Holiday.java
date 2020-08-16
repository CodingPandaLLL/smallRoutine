package exercise.tx;

import java.util.Scanner;

/*
由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：不会连续两天工作或锻炼。只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
 * 输入描述:
 * 第一行一个整数  表示放假天数
 * 第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
 * 第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
 * （1为营业 0为不营业）
 * 输出描述:
 * 一个整数，表示小Q休息的最少天数
 * 输入例子1:
 * 4
 * 1 1 0 0
 * 0 1 1 0
 * 输出例子1:
 * 2
 * 例子说明1:
 * 小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天
 */
public class Holiday {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int day = Integer.valueOf(sc.nextLine());
        String[] wDays = (sc.nextLine()).split(" ");
        int[] wDaysI = new int[day];
        for (int i = 0; i < wDays.length; i++) {
            wDaysI[i] = Integer.valueOf(wDays[i]);
        }
        String[] eDaysS = (sc.nextLine()).split(" ");
        int[] eDaysI = new int[day];
        for (int i = 0; i < eDaysS.length; i++) {
            eDaysI[i] = Integer.valueOf(eDaysS[i]);
        }

        //整合上班可上班日历
        String[] dDaysp = new String[day];
        for (int i = 0; i < day; i++) {
            if (wDaysI[i] == 1 && eDaysI[i] == 1) {
                dDaysp[i] = "Y";
            } else if (wDaysI[i] == 0 && eDaysI[i] == 1) {
                dDaysp[i] = "E";
            } else if (wDaysI[i] == 1 && eDaysI[i] == 0) {
                dDaysp[i] = "W";
            } else {
                dDaysp[i] = "X";
            }
        }

        //遍历日历调整计划
        for (int i = 0; i < dDaysp.length; i++) {
            if (i == 0) {
                if (dDaysp[i].equals("Y") && dDaysp[i + 1].equals("E")) {
                    dDaysp[i] = "W";
                } else if (dDaysp[i].equals("Y") && dDaysp[i + 1].equals("W")) {
                    dDaysp[i] = "E";
                }
            }
            if (i != dDaysp.length - 1) {
                if (dDaysp[i].equals("Y") && dDaysp[i - 1].equals("E")) {
                    dDaysp[i] = "W";
                } else if (dDaysp[i].equals("Y")) {
                    dDaysp[i] = "E";
                }
                if (dDaysp[i].equals("E") && dDaysp[i - 1].equals("E")) {
                    dDaysp[i] = "X";
                } else if (dDaysp[i].equals("Y")&& dDaysp[i - 1].equals("Y")) {
                    dDaysp[i] = "X";
                }
            }
        }

        int result=0;
        for (int i = 0; i < dDaysp.length ; i++) {
            if(dDaysp[i].equals("X")){
                result++;
            }
        }
        System.out.println(result);
    }
}
