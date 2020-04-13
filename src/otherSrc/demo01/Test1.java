package demo01;

public class Test1{
	public static void main(String[] args) {
		Test test = null;
		test.hello();
		Test test2 = new Test();
		test2.c = 3;
		Test test3 = new Test();
		System.out.println("test2.c=" + test2.c);
		System.out.println("Test.c=" + test3.c);
	}
}

class Test {
	public static int c = 1;
	public static void hello(){
		System.out.println("hello");
	}
}
