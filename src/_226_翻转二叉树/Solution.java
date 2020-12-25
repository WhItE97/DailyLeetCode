package _226_翻转二叉树;

public class Solution {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(4);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		t1.NonRecursionPreTraversal();
		TreeNode res = invertTree(t1);
		System.out.println();
		System.out.println("after invert************************");
		res.NonRecursionPreTraversal();
	}

	/**
	 * 思路：
	 * 就是对每个节点都进行左右子交换——>递归！
	 */
	public static TreeNode invertTree(TreeNode root) {
		//base case
		if(root==null) {
			return null;
		}
		
		//DLR前序遍历来处理每个节点
		//先处理根
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		//再遍历，对每一个节点做同等处理
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
