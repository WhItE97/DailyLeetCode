package _105_前序中序构造二叉树;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	//中序非递归遍历
	public void NonRecursionInorderTraversal() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = this;
		
		while(!st.isEmpty()||node!=null) {
			//LDR
			if(node!=null) {
				st.push(node);
				node = node.left;//L
			}
			else {//左压完了
				node = st.pop();
				System.out.print(node.val+" ");//D
				node = node.right;//R
			}
		}
	}
}
