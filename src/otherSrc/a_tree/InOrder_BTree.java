package a_tree;

import java.util.Stack;

/**
 * 二叉树的中序遍历
 * 1. 非递归
 * 2. 递归
 * @author zj
 *
 */
public class InOrder_BTree {

	public static void main(String[] args) {
		String s = "1(2(4(,7)),3(5,6))";
		BTNode root = null;
		root = createBTNode(root, s);
		//非递归中序遍历二叉树
		System.out.println("中序遍历非递归结果：");
		inOrder_NoRecursion(root);
		
		System.out.println();
		
		//递归中序遍历二叉树
		System.out.println("中序遍历递归结果：");
		inOrder_Recursion(root);
	}
	
	/**
	 * 非递归中序遍历
	 * @param root
	 */
	public static void inOrder_NoRecursion(BTNode root){
		if(root == null){
			return;
		}
		Stack<BTNode> st = new Stack<BTNode>();
		BTNode b = root;
		while(!st.isEmpty() || b != null){
			while(b != null){	//先找到最左下元素，将路径上元素均入栈
				st.push(b);
				b = b.lchild;
			}
			//执行到这里，栈顶元素没有左孩子或左子树均已访问过了
			if(!st.isEmpty()){	//栈不为空，访问栈顶元素
				BTNode tmp = st.pop();
				System.out.print(tmp.data + " ");
				b = tmp.rchild;		//转去处理栈顶元素的右子树
			}
		}
	}
	
	/**
	 * 递归中序遍历
	 * @param root
	 */
	public static void inOrder_Recursion(BTNode root){
		if(root == null){
			return;
		}
		inOrder_Recursion(root.lchild);
		System.out.print(root.data + " ");
		inOrder_Recursion(root.rchild);
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
