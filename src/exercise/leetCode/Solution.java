package exercise.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode listNode = null;
        //初始化鏈表
        ListNode listNode1 = addListNode(listNode, 1);
        System.out.printf("" + listNode1);
        //反向链表
        System.out.printf("" + Solution2.reverseList(listNode1));

    }

    /**
     * 递归生成
     *
     * @param listNode
     * @param i
     * @return exercise.leetCode.ListNode
     * @author: lll
     * @date: 2022年07月11日 18:07:33
     */
    public static ListNode addListNode(ListNode listNode, int i) {
        if (6 == i) {
            ListNode newListNode = new ListNode(i);
            newListNode.next = listNode;
            return newListNode;
        } else {
            ListNode newListNode = new ListNode(i);
            newListNode.next = listNode;
            i++;
            return addListNode(newListNode, i);
        }
    }

    public static ListNode reverseList(ListNode listNode) {
        if (listNode.next == null) {
            ListNode newListNode = null;
            newListNode.next = listNode;
            return newListNode;
        } else {
            ListNode newListNode = listNode.next;
            newListNode.next = listNode;
            return reverseList(newListNode);
        }
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
class Solution1 {
    public int[] reversePrint(ListNode head) {
        List<Integer> ssds = new ArrayList<>();
        int[] keys = new int[ssds.size()];
        if (head == null) {
            return keys;
        }
        while (head.next != null) {
            ssds.add(head.val);
            head = head.next;
        }
        ssds.add(head.val);

        keys = new int[ssds.size()];
        for (int i = 0; i < ssds.size(); i++) {
            int i1 = ssds.size() - i - 1;
            keys[i1] = ssds.get(i);
        }
        return keys;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
class Solution2 {
    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null, next = null;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: lll
 * @date: 2022年07月11日 23:07:27
 */
class Solution3 {
    public Node copyRandomList(Node head) {
  return null;
    }
}