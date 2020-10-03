package exercise.hw;

import java.util.Scanner;

/*
题目描述
考试题目和要点：
1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（40分）
输入描述:
输入一个double数
输出描述:
输出人民币格式

示例1
输入
151121.15
输出
人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 */
public class RMBConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String money = sc.nextLine();
            System.out.println(translareMoney(money));
        }
        //System.out.println(getChildIntPart(0,money));
    }

    public static String translareMoney(String money) {
        String[] partMoneys = money.split("\\.");
        String intPart = partMoneys[0];
        String decimalPart = partMoneys[1];
        String[] numHans = new String[]{"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾", "佰", "仟", "万", "亿", "元", "角", "分", "零", "整"};
        String end = "";
        if (decimalPart.equals("00")) {
            end = "整";
        } else {
            //解析小数部分
            int key1 = Integer.valueOf(decimalPart.charAt(1) + "") - 1;
            //分位如果是0不处理，不为0则翻译一下
            if (key1 != -1) {
                end = numHans[key1] + numHans[16] + end;
            }

            //角位如果是0翻译为零，不为0正常翻译加单位
            int key = Integer.valueOf(decimalPart.charAt(0) + "") - 1;
            if (key != -1) {
                end = numHans[key] + numHans[15] + end;
            }


        }
        String intPartStr = "";
        if(!"0".equals(intPart)){
            //将整数部分按照4位分段
            int duanNum = intPart.length() / 4;
            for (int j = 0; j < duanNum + 1; j++) {
                //按照段位赋予单位
                String unit = "";
                if (j == 0) {
                    unit = "元";
                } else if (j == 1) {
                    unit = "万";
                } else {
                    unit = "亿";
                }
                String cIntPart = getChildIntPart(j, intPart);
                int k = 1;
                //k是在四位分段中的位置
                for (int i = cIntPart.length(); i > 0; i--) {
                    //key是具体位置对应的值
                    int key = Integer.valueOf(cIntPart.charAt(i - 1) + "") - 1;
                    //如果对应位置的值为0，则特殊处理
                    if (key == -1) {
                        //如果个位数为则跳过并且加上单位
                        if (i == cIntPart.length()) {
                            intPartStr = unit + intPartStr;
                            k++;
                            continue;
                        } else {
                            //不是个位数为零的情况的需要判断前一位是否为0,
                            //前一位为0则跳过，判断下一位，前一位不为0则翻译为零
                            int oldKey = Integer.valueOf(cIntPart.charAt(i) + "");
                            if (oldKey == 0) {
                                k++;
                                continue;
                            } else {
                                intPartStr = numHans[17] + intPartStr;
                                k++;
                                continue;
                            }
                        }
                    } else {
                        //根据所在位置判断单位并翻译为中文
                        switch (k) {
                            case 1:
                                intPartStr = numHans[key] + unit + intPartStr;
                                k++;
                                break;
                            case 2:
                                if(key==0 && i==1){
                                    intPartStr = numHans[9] + intPartStr;
                                }else{
                                    intPartStr = numHans[key] + numHans[9] + intPartStr;
                                }
                                k++;
                                break;
                            case 3:
                                intPartStr = numHans[key] + numHans[10] + intPartStr;
                                k++;
                                break;
                            case 4:
                                intPartStr = numHans[key] + numHans[11] + intPartStr;
                                k++;
                                break;
                        }
                    }
                }
            }
        }
        intPartStr = "人民币" + intPartStr + end;
        return intPartStr;
    }

    public static String getChildIntPart(int i, String key) {
        String result = "";
        if (i == key.length() / 4) {
            result = key.substring(0, (key.length() - i * 4));
        } else {
            result = key.substring((key.length() - (i + 1) * 4), (key.length() - i * 4));
        }
        return result;
    }
}
