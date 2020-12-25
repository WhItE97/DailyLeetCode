package _114_��������չ��Ϊ����;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(5);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		
		NonRecursionPreTraversal(t1);
	}
	
	/**
	 * ��һ��labuladong�ĵݹ���
	 * ˼·��
	 * 1.Ҫʵ�ֱ�ɵ�������һ����root�����������ֱ�Ĩƽ��ȫΪ���ӵĵ������ڶ�����������������λ�ü���
	 * 2.���ԣ��ɺ���flatten��Ŀ�꣬���书����һ�����壺����ڵ�Ĩƽ��һ��������
	 * 3.���ԣ�ֱ�ӵ���flatten�ݹ鴦��root�������������ɣ���Ҫ�����ݹ�ϸ�ڣ�����Ҫcare flatten������ôwork�ģ�����������
	 * 4.����flatten����������������root����λ�õĵ��������ӽӵ�����ĩβ���������������ӣ�����
	 */
	public void flatten(TreeNode root) {
		//base
		if(root==null) {
			return;
		}
		//����flatten��ôwork�ģ��������Ķ������Ĩƽ�ýڵ��Ϊһ��������
		//����Ҫȥ�����ݹ��ϸ�ڣ�����
		//���Զ�root�����������ݹ鼴��
		flatten(root.left);
		flatten(root.right);
		
		//�ݹ���������Ӻ������Ѿ���Ĩƽ�ˣ�����root�������ӣ�����һ����������(��ͼ���)
		TreeNode right = root.right;
		root.right =  root.left;
		root.left = null;
		//�ݹ��ҵ�ĩβ��������֮ǰ��right
		while(root.right!=null) {
			root = root.right;
		}
		root.right = right;
	}
	
	/**
	 * ���������ԭ���д��
	 * ˼·��
	 * ���ѷ��֣�Ĩƽ�ɵ�������˳�򣬾��Ƕ�ԭ������ǰ�������˳��
	 * ���ԶԶ���������ǰ�������Ȼ���ø�listȥװ�ڵ㼴��
	 */
	public void flatten2(TreeNode root) {
		//base
		if(root == null) {
			return;
		}
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		nodes = NonRecursionPreTraversal(root);
		root.left = null;
		for(int i=1;i<nodes.size();i++) {
			root.right = nodes.get(i); 
			root.left = null;//ע��ǵ������������
			root = root.right;//����Ҫ��������������������һֱ�ظ�����root�ϰ�..����
		}
	}
	
	public static ArrayList<TreeNode> NonRecursionPreTraversal(TreeNode root){
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		TreeNode node = root;
		
		while(!st.isEmpty()) {
			node = st.pop();
			nodes.add(node);
			System.out.println(nodes.size());
			if(node.right!=null) {
				st.push(node.right);
			}
			if(node.left!=null) {
				st.push(node.left);
			}
		}
		return nodes;
	}
}
