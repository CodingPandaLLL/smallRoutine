package demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：
	在n个元素的数组中，找到差值为k的数字对去重后的个数。
	
	输入描述：
	第一行，n和k，n表示数字个数，k表示差值 
	第二行，n个正整数
	
	输出描述：
	差值为k的数字对去重后的个数
	
	样例
	in:
	5 2
	1 5 3 4 2
	out:
	3
 * @author zj
 *
 */
public class MainToutiao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
        	a[i] = sc.nextInt();
        }
        
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int count = 0;
        Arrays.sort(a);	//先排序，然后去重，双重循环，分别代表第一个数和第二个数的选取，均要去重
        //如：1 2 2 3 4，其中n=5，k=2，那么结果有(1,3),(2,4)，
        //但外层循环为1时，先与2计算差，又与2计算差，多次计算，所以内层判断若是多个重复值则跳过
        //同理，外层为2时与3,4计算，外层为第二个2时还与3,4计算，所以外层也判断若多个重复值则跳过计算
        for(int i = 0; i < n; i++){
        	for(int j = i + 1; j < n; j++){
        		System.out.println(j + "--" + a[j]);
        		if(a[j] - a[i] == k){
        			List<Integer> l = new ArrayList<Integer>();
        			l.add(a[i]);
        			l.add(a[j]);
//        			if(!resultList.contains(l)){	
        				resultList.add(l);
        				count ++;
//        			}
        		}else if(a[j] - a[i] > k){
        			break;
        		}
        		while(j + 1 < n && a[j+1] == a[j]){	//内层循环去重，如果后面一个数与当前数相等，则跳过
        			j++;
        		}
        	}
        	while(i + 1 < n && a[i+1] == a[i]){		//外层循环去重，如果后面一个数与当前数相等，则跳过
        		i++;
        	}
        }
        System.out.println(count);
	}
}
