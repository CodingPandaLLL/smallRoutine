package exercise.leetCode;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author: lll
 * @date: 2022年07月11日 16:07:00
 */
public class MinStack {

        Set<Integer> mm = new TreeSet<>();

        Stack<Integer> s = new Stack<>();

/**
 * initialize your data structure here.
 */
public MinStack() {

        }

public void push(int x) {

//            if (s.empty()) {
//                min = x;
//                max = x;
//            } else {
//                if (x <= min) {
//                    min = x;
//                }
//                if (x >= max) {
//                    max = x;
//                }
//            }
        mm.add(x);
//        mm.stream().sorted().min();
        s.push(x);
        }

public void pop() {
        Integer key = s.pop();
        if (!s.contains(key)) {
        mm.remove(key);
        }
        }

public int top() {
        return s.peek();
        }

public int min() {
        return mm.iterator().next();
        }
        }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */