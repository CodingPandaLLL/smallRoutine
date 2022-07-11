package exercise.leetCode;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class CQueue {

    private Stack<Integer> x = new Stack<>();
    private Stack<Integer> y = new Stack<>();


    public CQueue() {
    }

    public void appendTail(int value) {
        x.push(value);
    }

    public int deleteHead() {
        if(x.empty()){
            return -1;
        }
        //先将x栈中的数据全部推入到y
        while (!x.empty()){
            y.push(x.pop());
        }
        //再将y删除一个
        Integer result = y.pop();
        //再将y推入x中
        while (!y.empty()){
            x.push(y.pop());
        }
        return result;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */