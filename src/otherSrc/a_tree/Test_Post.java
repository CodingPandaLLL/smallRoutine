package a_tree;

import java.util.Stack;

/**
 * 二叉树的后序遍历
 * 1. 非递归
 * 2. 递归
 * @author zj
 *
 */
public class Test_Post {

	public static void main(String[] args) {
		String s = "1(2(4(,7)),3(5,6))";
		BTNode root = null;
		root = createBTNode(root, s);
		//非递归后序遍历二叉树
		System.out.println("后序遍历非递归结果：");
		postOrder_NoRecursion(root);
		
		System.out.println();
		
		//递归后序遍历二叉树
		System.out.println("后序遍历递归结果：");
		postOrder_Recursion(root);
	}
	
	/**
	 * 非递归后序遍历
	 * @param root
	 */
	public static void postOrder_NoRecursion(BTNode root){
		if(root != null){
			Stack<BTNode> st = new Stack<BTNode>();
			BTNode p = root;
			st.push(p);
			p = p.lchild;
			while(!st.isEmpty()){
				while(p != null){
					st.push(p);
					p = p.lchild;
				}
				BTNode pre = null;
				boolean flag = true;
				while(!st.isEmpty() && flag){
					p = st.peek();
					if(pre == p.rchild){
						p = st.pop();
						System.out.print(p.data + " ");
						pre = p;
					}else{
						p = p.rchild;
						flag = false;
					}
				}
			}
		}
	}
	
	/**
	 * 递归后序遍历
	 * @param root
	 */
	public static void postOrder_Recursion(BTNode root){
		if(root == null){
			return;
		}
		postOrder_Recursion(root.lchild);
		postOrder_Recursion(root.rchild);
		System.out.print(root.data + " ");
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
