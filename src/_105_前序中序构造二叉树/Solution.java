package _105_前序中序构造二叉树;

public class Solution {
/**
 * 思路：
 * ele：①二叉树的前序序列首位为每一轮的根节点②根节点将中序序列划分成左右子树
 * 所以：每次递归都在给出preorder和inorder序列的情况下，再给出该次递归的子树范围
 * 即：preorder的起点和中的，inorder的起点和终点（画图理解！这样不容易出错）
 * 所以：每次递归就找出一个根，然后对其左子和右子，限定数组范围，递归调用该方法即可
 */
	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7};
		TreeNode root = buildTree(preorder,inorder);
		root.NonRecursionInorderTraversal();
	}

	//根据前序和中序遍历生成树
	public static TreeNode buildTree(int[] preorder,int[] inorder) {
		//base
		if(preorder.length==0||inorder.length==0) {
			return null;
		}
		return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}
	
	//[start,end]
	public static TreeNode buildTree(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend) {
		//base
		if(prestart>preend) {
			return null;
		}
		//先生成根
		TreeNode node = new TreeNode(preorder[prestart]);
		//找到中序中根对应的下标:::其也能辅助求左右子树长度/节点数
		int tag = -1;//存放中序的根的位置
		for(int i=instart;i<=inend;i++) {
			if(inorder[i]==preorder[prestart]) {
				tag = i;
				break;
			}
		}
		int leftlength = tag-instart;
		node.left = buildTree(preorder,prestart+1,prestart+leftlength,inorder,instart,tag-1);
		node.right = buildTree(preorder,prestart+leftlength+1,preend,inorder,tag+1,inend);
		return node;
	}
}
