package _106_��������������;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	//ǰ��ǵݹ������DLR
	public void NonRecursionPreorderTraversal() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = this;
		st.push(node);
		
		while(!st.isEmpty()) {
			//DLR
			node = st.pop();
			System.out.print(node.val+" ");//D
			if(node.right!=null) {
				st.push(node.right);//�Ƚ������������ѹR
			}
			if(node.left!=null) {
				st.push(node.left);//��ѹL
			}
		}
	}
}
