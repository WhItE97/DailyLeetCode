package _226_��ת������;

import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		val = x;
	}
	
	//�ǵݹ�ǰ�����
	public void NonRecursionPreTraversal() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode node = this;
		st.push(node);//ѹ����ڵ�
		
		while(!st.isEmpty()) {//����ֻ��ջ���վ��У�����ķǵݹ��Ҫ||node!=null
			node = st.pop();
			System.out.print(node.val+" ");//D
			//DLR���Ե���ѹ�ң���ѹ��
			if(node.right!=null) {
				st.push(node.right);
			}
			if(node.left!=null) {
				st.push(node.left);
			}
		}
	}
}
