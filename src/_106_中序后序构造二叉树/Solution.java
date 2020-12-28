package _106_中序后序构造二叉树;

public class Solution {
/**
 * 思路：
 * 类比前序+中序 构造二叉树
 * Ele：①后序的根节点在末尾②根据后续获取的根节点，可把中序砍成左右子树
 * 每次递归取出一个根节点，然后递归他的左子和右子
 * 所以每次需要输入该次节点选取的中序和后序的数组范围（即每个数组+其起始 6个参数——>重载）
 */
	public static void main(String[] args) {
		int[] inorder = new int[] {9,3,15,20,7};
		int[] postorder = new int[] {9,15,7,20,3};
		TreeNode root = buildTree(inorder,postorder);
		root.NonRecursionPreorderTraversal();
	}
	
	public static TreeNode buildTree(int[] inorder,int[] postorder) {
		if(inorder.length==0||postorder.length==0) {
			return null;
		}
		return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
	}

	public static TreeNode buildTree(int[] inorder,int instart,int inend,int[] postorder,int poststart,int postend) {
		//base
		if(instart>inend) {
			return null;
		}
		
		TreeNode node = new TreeNode(postorder[postend]);//根节点
		//找根节点在中序序列的下标
		int tag = -1;
		for(int i=instart;i<=inend;i++) {
			if(inorder[i]==postorder[postend]) {
				tag = i;
				break;
			}
		}
		//左右子递归
		int leftsize = tag-instart;//左子树的节点数
		node.left = buildTree(inorder,instart,tag-1,postorder,poststart,poststart+leftsize-1);
		node.right = buildTree(inorder,tag+1,inend,postorder,poststart+leftsize,postend-1);
		return node;
	}
}
