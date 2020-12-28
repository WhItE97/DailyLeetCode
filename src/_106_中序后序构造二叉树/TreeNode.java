package _106_中序后序构造二叉树;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	//前序非递归遍历：DLR
	public void NonRecursionPreorderTraversal() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = this;
		st.push(node);
		
		while(!st.isEmpty()) {
			//DLR
			node = st.pop();
			System.out.print(node.val+" ");//D
			if(node.right!=null) {
				st.push(node.right);//先进后出，所以先压R
			}
			if(node.left!=null) {
				st.push(node.left);//后压L
			}
		}
	}
}
