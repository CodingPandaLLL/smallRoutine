package a_tree;

import java.util.Stack;

/**
 * 二叉树的先序遍历
 * 1. 非递归
 * 2. 递归
 * @author zj
 *
 */
public class PreOrder_BTree {

	public static void main(String[] args) {
		String s = "1(2(4(,7)),3(5,6))";
		BTNode root = null;
		root = createBTNode(root, s);
		//非递归先序遍历二叉树
		System.out.println("先序遍历非递归结果：");
		preOrder_NoRecursion(root);
		
		System.out.println();
		
		//递归先序遍历二叉树
		System.out.println("先序遍历递归结果：");
		preOrder_Recursion(root);
	}
	
	/**
	 * 非递归先序遍历
	 * @param root
	 */
	public static void preOrder_NoRecursion(BTNode root){
		if(root == null){
			return;
		}
		Stack<BTNode> st = new Stack<BTNode>();
		st.push(root);
		while(!st.isEmpty()){
			BTNode p = st.pop();
			System.out.print(p.data + " ");
			if(p.rchild != null){
				st.push(p.rchild);
			}
			if(p.lchild != null){
				st.push(p.lchild);
			}
		}
	}
	
	/**
	 * 递归先序遍历
	 * @param root
	 */
	public static void preOrder_Recursion(BTNode root){
		if(root == null){
			return;
		}
		System.out.print(root.data + " ");
		preOrder_Recursion(root.lchild);
		preOrder_Recursion(root.rchild);
	}
	
	/**
	 * 根据括号表示法创建二叉树
	 * @param root
	 * @param s
	 */
	public static BTNode createBTNode(BTNode root, String s){
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode p =  null;
		int k = 0;
		for(int i = 0; i  < s.length(); i++){
			switch(s.charAt(i)){
			case '(':
				stack.push(p);
				k = 1;
				break;
			case ')':
				stack.pop();
				break;
			case ',':
				k = 2;
				break;
			default:
				p = new BTNode();
				p.data = s.charAt(i) - '0';
				if(root == null){
					root = p;
				}else{
					switch(k){
					case 1:
						stack.peek().lchild = p;
						break;
					case 2:
						stack.peek().rchild = p;
						break;
					}
				}
			}
		}
		return root;
	}
}
