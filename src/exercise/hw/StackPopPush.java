package exercise.hw;

import java.util.Stack;


/**
 * @author lll
 * @time 2019年12月17日下午1:36:44
 * @describe 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class StackPopPush {
    //初始化
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    // push操作
    public static void push(int node) {
        if (!stack2.empty()) {
            for (int i = stack2.size() - 1; i >= 0; i--) {
                stack1.push(stack2.get(i));
            }
        }
        stack2.clear();
        stack1.add(node);
    }

    // pop操作
    public static int pop() {
        if (!stack1.empty()) {
            for (int i = stack1.size() - 1; i >= 0; i--) {
                stack2.add(stack1.get(i));
            }
        }
        stack1.clear();
        return stack2.pop();
    }


    // 调用测试
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        push(5);
        System.out.println(pop());
        System.out.println(pop());

    }
}
