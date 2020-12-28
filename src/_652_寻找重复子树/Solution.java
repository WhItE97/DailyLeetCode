package _652_Ѱ���ظ�����;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
/**
 * ˼·��
 * ϸ����ÿһ���ڵ㣬Ӧ����ʲô��
 * forÿһ���ڵ㣺������Ϊ���Ķ�������ɶ���������������ڵ�Ϊ���Ķ�������ɶ������
 * HDP1.��μ�¼��������ģ��������>ƴ���ַ�������ʽ�Ѷ��������л�����������Ϊ#������Ϊ�ýڵ��val��
 * HDP2.��δ�����нڵ���������л�����������ǻ���Ҫ������бȶԣ��Ƿ��г���һ�������л������
 * 		����>HashSet�����������������ֶ���ظ�������HashSetֻ��˵�����ظ��ˣ�����������������������ظ������Ľڵ�ļ��ϣ������ջ�����ظ�
 * 		����>HashMap����value��¼����ִ�������������res���ظ�
 * HDP3.������ʽ��ѡȡ����>LRD��Ҫ��֪���Լ�Ϊ���ڵ������ģ������Ȼ��Ҫ֪���Լ������Ӻ����ӵ�ģ��
 */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(22);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(12);
		TreeNode t6 = new TreeNode(1);
		TreeNode t7 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		List<TreeNode> res = findDuplicateSubtrees(t1);
		Iterator<TreeNode> it = res.iterator();
		while(it.hasNext()) {
			it.next().preorderTraversal();
			System.out.println();
		}
	}

	
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root){
		//LRD�������нڵ㣬����������ģ��������һ��HashMap���ں����ȶ�
		HashMap<String,Integer> memo = new HashMap<String,Integer>();
		//������������Ľڵ�Ľ����(trick:linkedlist�ڲ����ɾ��ʱ���нϺ�����)
		LinkedList<TreeNode> res = new LinkedList<TreeNode>();
		
		//��ʼLRD����
		postorderTraversal(memo,res,root);
		return res;
	}
	
	//����LRD����
	public static void postorderTraversal(HashMap<String,Integer> memo,LinkedList<TreeNode> res,TreeNode node) {
		//base
		if(node==null) {
			return;
		}
		//LRD
		postorderTraversal(memo,res,node.left);
		postorderTraversal(memo,res,node.right);
		//D��ʼ����
		String s = traverse(node);
		//��ȡ��������ʼ�ȶ�HashMap�Ƿ����д�����
		if(memo.containsKey(s)) {
			//�Ѿ����ڴ���������Ҫ�����ж����ǵڼ����ظ���ֻ�ڵڶ����ظ��������res�����
			if(memo.get(s)==1) {
				res.add(node);
				memo.put(s, memo.get(s)+1);
			}
		}
		//���û�д������������HashMap
		else {
			memo.put(s,1);
		}
	}
	
	//����һ���ڵ㣬��¼��ǰ�ڵ�ġ�ģ��������>���ַ���ƴ����ʽ�����л����
	public static String traverse(TreeNode node) {
		//base
		if(node==null) {
			return "#";//�սڵ�����Ϊ#
		}
		
		//���������¼ģ��LRD
		String left = traverse(node.left);
		String right = traverse(node.right);
		//D��ʼ����
		String res = left+","+right+","+node.val;
		return res;
	}
}
