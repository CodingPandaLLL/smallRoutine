package a_tree;

import java.util.Stack;

/**
 * 二叉树的后序遍历
 * 1. 非递归
 * 2. 递归
 * @author zj
 *
 */
public class PostOrder_BTree {

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
		if(root == null){
			return;
		}
		Stack<BTNode> st = new Stack<BTNode>();
		BTNode b = root;
		st.push(b);							//先将根节点进栈
		b = b.lchild;						//b指向栈顶元素左孩子
		while(!st.isEmpty()){				//栈不为空循环
			while(b != null){				//找到栈顶元素的最左孩子
				st.push(b);
				b = b.lchild;
			}
			BTNode p = null;				//p用来保存栈顶节点的前一个访问过的节点
			boolean flag = true;			//为true表示b的左孩子节点已经访问过或为空
			while(!st.isEmpty() && flag){	//如果栈不为空，且当前b的左孩子节点已经访问过
				b = st.peek();
				if(b.rchild == p){			//如果当前b的右孩子节点等于null或是刚刚访问过的节点，那么可以访问b节点了
					System.out.print(b.data + " ");
					b = st.pop();
					p = b;					//p继续指向刚刚访问过的节点
				}else{
					b = b.rchild;
					flag = false;			//为false表示b的左孩子节点尚未访问过
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
