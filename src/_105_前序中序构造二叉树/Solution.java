package _105_ǰ�������������;

public class Solution {
/**
 * ˼·��
 * ele���ٶ�������ǰ��������λΪÿһ�ֵĸ��ڵ�ڸ��ڵ㽫�������л��ֳ���������
 * ���ԣ�ÿ�εݹ鶼�ڸ���preorder��inorder���е�����£��ٸ����ôεݹ��������Χ
 * ����preorder�������еģ�inorder�������յ㣨��ͼ��⣡���������׳���
 * ���ԣ�ÿ�εݹ���ҳ�һ������Ȼ��������Ӻ����ӣ��޶����鷶Χ���ݹ���ø÷�������
 */
	public static void main(String[] args) {
		int[] preorder = new int[] {3,9,20,15,7};
		int[] inorder = new int[] {9,3,15,20,7};
		TreeNode root = buildTree(preorder,inorder);
		root.NonRecursionInorderTraversal();
	}

	//����ǰ����������������
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
		//�����ɸ�
		TreeNode node = new TreeNode(preorder[prestart]);
		//�ҵ������и���Ӧ���±�:::��Ҳ�ܸ�����������������/�ڵ���
		int tag = -1;//�������ĸ���λ��
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
