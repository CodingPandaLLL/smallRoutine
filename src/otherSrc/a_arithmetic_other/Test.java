package a_arithmetic_other;

import java.util.Hashtable;
import java.util.Map;

public class Test{
	public static void main(String[] args) {
		Father c = new Child();
		c.eat();
		System.out.println(c.age);
	}
}

class Father {

	protected int age;
	public Father(){
		age = 40;
	}
	void eat(){
		System.out.println("father eat");
	}
}

class Child extends Father{
	protected int age;
	public Child(){
		age = 18;
	}
	void play(){
		System.out.println("child play");
	}
	void eat(){
		System.out.println("child eat");
	}
}
