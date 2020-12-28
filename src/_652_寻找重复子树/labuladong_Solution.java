package _652_Ѱ���ظ�����;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class labuladong_Solution {
	/**
	 * ˼·��
	 * ϸ����ÿһ���ڵ㣬Ӧ����ʲô��
	 * forÿһ���ڵ㣺������Ϊ���Ķ�������ɶ���������������ڵ�Ϊ���Ķ�������ɶ������
	 * HDP1.��μ�¼��������ģ��������>ƴ���ַ�������ʽ�Ѷ��������л�����������Ϊ#������Ϊ�ýڵ��val��
	 * HDP2.��δ�����нڵ���������л�����������ǻ���Ҫ������бȶԣ��Ƿ��г���һ�������л������
	 * 		����>HashSet�����������������ֶ���ظ�������HashSetֻ��˵�����ظ��ˣ�����������������������ظ������Ľڵ�ļ��ϣ������ջ�����ظ�
	 * 		����>HashMap����value��¼����ִ�������������res���ظ�
	 * HDP3.������ʽ��ѡȡ����>LRD��Ҫ��֪���Լ�Ϊ���ڵ������ģ������Ȼ��Ҫ֪���Լ������Ӻ����ӵ�ģ��
	 * ATT���Լ��Ĵ������㣺traverse���к�����������У�������ÿ���㣬���Ѿ������ȶ��ˣ���Ҫ����һ���������ȥ����traverse�ˣ�
	 */
	public static void main(String[] args) {
		labuladong_Solution s = new labuladong_Solution();
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(11);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(1);
//		TreeNode t6 = new TreeNode(1);
//		TreeNode t7 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
//		t2.right = t5;
		t3.left = t5;
//		t3.right = t7;
		List<TreeNode> res = s.findDuplicateSubtrees(t1);
		System.out.println(res.size());
		Iterator<TreeNode> it = res.iterator();
		while(it.hasNext()) {
			it.next().preorderTraversal();
			System.out.println();
		}
	}
	
	HashMap<String,Integer> memo = new HashMap<String,Integer>();
	LinkedList<TreeNode> res = new LinkedList<TreeNode>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root){
		//base
		if(root==null) {
			return null;
		}
		traverse(root);//��Ҫ���˵���
		return res;
	}
	
	public String traverse(TreeNode node){
		//base
		if(node==null) {
			return "#";
		}
		//LRD����
		String left = traverse(node.left);
		String right = traverse(node.right);
		//D����
		String subTree = left+','+right+','+node.val;//������źܹؼ���������...170/175���������� ����ȱ��������ţ�
		System.out.println(subTree);
		//��ʼ��ͼ����hashmap
		int count = memo.getOrDefault(subTree, 0);//����subTree key��value�����û�У�������defaultΪ0;countΪ����ִ�������
		if(count==1) {
			//����ǵڶ��γ����ˣ��������res
			res.add(node);
		}
		//�������ǵڼ��γ��֣�ֻҪ�����ˣ�count��Ҫ��һ��
		memo.put(subTree, count+1);
		return subTree;
	}
}
