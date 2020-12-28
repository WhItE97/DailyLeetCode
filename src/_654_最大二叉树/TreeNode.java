package _654_��������;

import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
       this.right = right;
    }
    
    //�ǵݹ��������
    public void NonRecursionInorderTraversal() {
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode node = this;
    	
    	while(!st.isEmpty()||node!=null) {//��Ϊ�ǵݹ������������ж�����������һ��ʼ���õ���ջ�ս�������Ҳ�Ͳ�Ҫѹ��this��
    		//LDR:��һ·ѹ�������µĽڵ�
    		if(node!=null) {
    			st.push(node);
    			node = node.left;
    		}
    		//node�ߵ������º��ӵ������ˣ�=null�ˣ�pop�������ӣ���ѹ����������
    		else{
    			node = st.pop();
    			System.out.print(node.val+" ");
    			node = node.right;
    		}
    	}
    }
}