package _105_ǰ�������������;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	//����ǵݹ����
	public void NonRecursionInorderTraversal() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = this;
		
		while(!st.isEmpty()||node!=null) {
			//LDR
			if(node!=null) {
				st.push(node);
				node = node.left;//L
			}
			else {//��ѹ����
				node = st.pop();
				System.out.print(node.val+" ");//D
				node = node.right;//R
			}
		}
	}
}
