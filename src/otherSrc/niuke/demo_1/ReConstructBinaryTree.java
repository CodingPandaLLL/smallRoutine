package niuke.demo_1;

public class ReConstructBinaryTree {
	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		TreeNode result = reConstructBinaryTree(pre, in);
		printTreeNode(result);
	}

	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        return constructBinaryHelper(pre, in, 0, pre.length-1, 0, in.length-1);
    }
    
    public static TreeNode constructBinaryHelper(int[] pre, int[] in, int preS, int preE, int inS, int inE){
        if(preS > preE){
            return null;
        }
        TreeNode root = new TreeNode(pre[preS]);
        if(preS == preE){
            return root;
        }
        int inIndex = binarySearch(pre[preS], in, inS, inE);
        System.out.println(pre[preS] + "-" + pre[preE] + "; " + in[inS] + "-" + in[inE] + ": " + in[inIndex]);
        int len = inIndex - inS;
        root.left = constructBinaryHelper(pre, in, preS+1, preS+len, inS, inIndex-1);
        root.right = constructBinaryHelper(pre, in, preS+len+1, preE, inIndex+1, inE);
        return root;
    }
    
    public static int binarySearch(int target, int[] arr, int start, int end){
        while(start < end){
            int mid = (start + end)/2;
            if(arr[mid] == target){
//            	System.out.println(arr[start] + "-" + arr[end] + ": " + arr[mid]);
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return 0;
    }
    
    public static void printTreeNode(TreeNode root){
    	if(root != null){
    		System.out.print(root.val);
    		printTreeNode(root.left);
    		printTreeNode(root.right);
    	}
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
