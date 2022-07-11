import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Solution minStack = new Solution();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.printf(minStack.min() + "");
//        minStack.pop();
//        System.out.printf(minStack.top() + "");
//        System.out.printf(minStack.min() + "");
        ListNode listNode = null;
        for (int i = 0; i < 6; i++) {
            ListNode listNode1=new ListNode(i+1);
            ListNode listNode2=new ListNode(i+1);
            listNode1=listNode;
            listNode1=listNode;
            listNode.next = new ListNode(i + 1);

        }
        System.out.printf("" + listNode);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> ssds = new ArrayList<>();
        while (head.next != null) {
            ssds.add(head.val);
            head = head.next;
        }
        ssds.add(head.val);

        int[] keys = new int[ssds.size()];
        for (int i = ssds.size() - 1; i > 0; i--) {
            keys[i] = ssds.get(i);
        }
        return keys;
    }
}
