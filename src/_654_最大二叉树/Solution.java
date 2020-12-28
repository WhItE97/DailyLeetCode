package _654_最大二叉树;

public class Solution {
/**
 * 思路：
 * 对于构造二叉树的问题，根节点要做的就是想办法把自己构造出来！
 * 先找到一个maxValue，生成一个节点，即为根节点
 * 并且root.left=（与根节点同样方法生成的 根节点下标左边的数组中 最大值的节点）
 * root.right = （与根节点同样方法生成的 根节点下标右边的数组中 最大值的节点）
 * ——>先然这两个都得用到两个tag：left和right来限制位置了
 * 所以——>重载一个能加入起始和结束位置限制的constructMaximumBinaryTree函数
 */
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,1,6,0,5};
		TreeNode root = constructMaximumBinaryTree(nums);
		root.NonRecursionInorderTraversal();
	}

	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		//base
		if(nums.length==0) {
			return null;
		}
		//获取max value
		int tag = Max(nums,0,nums.length-1);
		TreeNode root = new TreeNode(nums[tag]);
		//左右子遍历
		root.left = constructMaximumBinaryTree(nums,0,tag-1);
		root.right = constructMaximumBinaryTree(nums,tag+1,nums.length-1);
		return root;
	}
	
	public static TreeNode constructMaximumBinaryTree(int[] nums,int left,int right) {
		//base
		if(left>right) {//等于的时候？
			return null;
		}
		int tag = Max(nums,left,right);
		TreeNode node = new TreeNode(nums[tag]);
		node.left = constructMaximumBinaryTree(nums,left,tag-1);
		node.right = constructMaximumBinaryTree(nums,tag+1,right);
		return node;
	}
	
	//用于求划定区间内max，返回max的下标
	public static int Max(int[] nums,int left,int right) {
		int tag = left;
		int max = nums[left];
		for(int i=left+1;i<=right;i++) {
			if(nums[i]>max) {
				tag = i;
				max = nums[i];
			}
		}
		return tag;
	}
}
