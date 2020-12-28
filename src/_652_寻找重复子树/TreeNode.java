package _652_Ѱ���ظ�����;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
	    this.left = left;
	    this.right = right;
	}
	
	public void preorderTraversal() {
		preorderTraversal(this);
	}
	
	//DLR�ݹ�
	public void preorderTraversal(TreeNode node) {
		if(node==null) {
			return;
		}
		System.out.print(node.val+" ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
}
