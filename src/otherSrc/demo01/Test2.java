package demo01;

import java.util.Iterator;

public class Test2 {
	private static void testMethod(){
        System.out.println("testMethod");
   }
   public static void main(String[] args) {
        ((Test2)null).testMethod();
        String ￥中 = "aa";
        System.out.println(￥中);
        Iterator it = null;
   }
}
