package _226_翻转二叉树;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		val = x;
	}
	
	//非递归前序遍历
	public void NonRecursionPreTraversal() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = this;
		st.push(node);//压入根节点
		
		while(!st.isEmpty()) {//先序只用栈不空就行！中序的非递归才要||node!=null
			node = st.pop();
			System.out.print(node.val+" ");//D
			//DLR所以得先压右，再压左
			if(node.right!=null) {
				st.push(node.right);
			}
			if(node.left!=null) {
				st.push(node.left);
			}
		}
	}
}
