package _654_��������;

public class Solution {
/**
 * ˼·��
 * ���ڹ�������������⣬���ڵ�Ҫ���ľ�����취���Լ����������
 * ���ҵ�һ��maxValue������һ���ڵ㣬��Ϊ���ڵ�
 * ����root.left=������ڵ�ͬ���������ɵ� ���ڵ��±���ߵ������� ���ֵ�Ľڵ㣩
 * root.right = ������ڵ�ͬ���������ɵ� ���ڵ��±��ұߵ������� ���ֵ�Ľڵ㣩
 * ����>��Ȼ�����������õ�����tag��left��right������λ����
 * ���ԡ���>����һ���ܼ�����ʼ�ͽ���λ�����Ƶ�constructMaximumBinaryTree����
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
		//��ȡmax value
		int tag = Max(nums,0,nums.length-1);
		TreeNode root = new TreeNode(nums[tag]);
		//�����ӱ���
		root.left = constructMaximumBinaryTree(nums,0,tag-1);
		root.right = constructMaximumBinaryTree(nums,tag+1,nums.length-1);
		return root;
	}
	
	public static TreeNode constructMaximumBinaryTree(int[] nums,int left,int right) {
		//base
		if(left>right) {//���ڵ�ʱ��
			return null;
		}
		int tag = Max(nums,left,right);
		TreeNode node = new TreeNode(nums[tag]);
		node.left = constructMaximumBinaryTree(nums,left,tag-1);
		node.right = constructMaximumBinaryTree(nums,tag+1,right);
		return node;
	}
	
	//�����󻮶�������max������max���±�
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
