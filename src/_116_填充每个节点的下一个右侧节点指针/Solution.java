package _116_���ÿ���ڵ����һ���Ҳ�ڵ�ָ��;

public class Solution {
/**
 * ��Ŀ��
 * ����һ��������������������Ҷ����ͬһ�㣬ÿ�����ڵ㶼�������ӽڵ�
 * �������ÿ��nextָ�룬ʹ��ָ����һ���Ҳ�ڵ㣻����Ҳ�������next��Ϊnull
 * 
 * ˼·��
 * ���֮ͬǰ�������������ѵ����ڣ���ΰ���ĿҪ��ϸ��Ϊÿ���ڵ�Ҫ�������顱��˼·����ÿ���ڵ��������������
 * ����ʵ��ͬ���з�ͬһ�����ڵ㣨�縸�ڵ㣩�������ڵ�֮������ӣ���ڵ���Ҷ��Ӻ��ҽڵ������ӣ���
 * so, change
 * ��ϸ��Ϊÿһ���ڵ㲻�С�����>�Ǿ����Ӻ���������һ���ڵ㲻�����͸������������ڵ㣡
 * Ŀ���ɡ���ÿһ��������ڵ�����������ϸ��Ϊ����ÿ�������ڽڵ㶼����������
 */
	public static void main(String[] args) {
		
	}

	public Node connect(Node root) {
		//base
		if(root==null) {
			return null;
		}
		connectTwo(root.left,root.right);
		return root;
	}
	
	public void connectTwo(Node node1,Node node2) {
		//��Ҫ����base..������
		if(node1==null) {//��Ϊ�������������������һ������or����Ϊnull������������
			return;
		}
		
		//�Ȱ�������������
		node1.next = node2;
		//�ٷֱ��������Լ���������
		connectTwo(node1.left,node1.right);
		connectTwo(node2.left,node2.right);
		//��Ҫ����������ӵĶ���
		connectTwo(node1.right,node2.left);
	}
}
