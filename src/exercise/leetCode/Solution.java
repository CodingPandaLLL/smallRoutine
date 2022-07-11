package exercise.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
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
     ListNode(int x) { val = x; }
 }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
class Solution1 {
    public int[] reversePrint(ListNode head) {
        List<Integer> ssds=new ArrayList<>();
        int[] keys=new int[ssds.size()];
        if(head==null){
            return keys;
        }
        while(head.next!=null){
            ssds.add(head.val);
            head=head.next;
        }
        ssds.add(head.val);

        keys=new int[ssds.size()];
        for(int i=0;i<ssds.size();i++){
            int i1 = ssds.size() - i - 1;
            keys[i1]= ssds.get(i);
        }
        return keys;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null,next=null;
        while (head != null) {
            next=head.next;
            head.next = pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}