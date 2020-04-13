package niuke.demo_1;

public class SortLinkedList {
	public static void main(String[] args) {
		int[] a = {3, 2, 4};
		ListNode root = generateList(a);
		ListNode result = sortList(root);
		printList(result);
	}

	/**
	 * 快慢指针找中点，然后递归归并排序
	 * @param head
	 * @return
	 */
	public static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;
        left = sortList(left);
        right = sortList(right);
        ListNode result = merge(left, right);
        return result;
    }
    
    public static ListNode merge(ListNode left, ListNode right){
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }
        ListNode result;
        if(left.val <= right.val){
            result = new ListNode(left.val);
            left = left.next;
        }else{
            result = new ListNode(right.val);
            right = right.next;
        }
        ListNode p = result;
        while(left != null && right != null){
            while(left != null && right != null && left.val <= right.val){
                ListNode tmp = new ListNode(left.val);
                p.next = tmp;
                p = p.next;
                left = left.next;
            }
            while(right != null && left != null && right.val <= left.val){
                ListNode tmp = new ListNode(right.val);
                p.next = tmp;
                p = p.next;
                right = right.next;
            }
        }
        if(left != null){
            while(left != null){
                ListNode tmp = new ListNode(left.val);
                p.next = tmp;
                p = p.next;
                left = left.next;
            }
        }else if(right != null){
            while(right != null){
                ListNode tmp = new ListNode(right.val);
                p.next = tmp;
                p = p.next;
                right = right.next;
            }
        }
        return result;
    }
    
    public static ListNode generateList(int[] a){
    	ListNode root = new ListNode(-1);
    	ListNode r = root;
    	for(int i = 0; i < a.length; i++){
    		ListNode tmp = new ListNode(a[i]);
    		r.next  = tmp;
    		r = r.next;
    	}
    	return root.next;
    }
    
    public static void printList(ListNode root){
    	while(root != null){
    		System.out.print(root.val + ", ");
    		root = root.next;
    	}
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
