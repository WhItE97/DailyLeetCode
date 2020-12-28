package _106_��������������;

public class Solution {
/**
 * ˼·��
 * ���ǰ��+���� ���������
 * Ele���ٺ���ĸ��ڵ���ĩβ�ڸ��ݺ�����ȡ�ĸ��ڵ㣬�ɰ����򿳳���������
 * ÿ�εݹ�ȡ��һ�����ڵ㣬Ȼ��ݹ��������Ӻ�����
 * ����ÿ����Ҫ����ôνڵ�ѡȡ������ͺ�������鷶Χ����ÿ������+����ʼ 6����������>���أ�
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
		
		TreeNode node = new TreeNode(postorder[postend]);//���ڵ�
		//�Ҹ��ڵ����������е��±�
		int tag = -1;
		for(int i=instart;i<=inend;i++) {
			if(inorder[i]==postorder[postend]) {
				tag = i;
				break;
			}
		}
		//�����ӵݹ�
		int leftsize = tag-instart;//�������Ľڵ���
		node.left = buildTree(inorder,instart,tag-1,postorder,poststart,poststart+leftsize-1);
		node.right = buildTree(inorder,tag+1,inend,postorder,poststart+leftsize,postend-1);
		return node;
	}
}
