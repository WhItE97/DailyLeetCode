package _654_最大二叉树;

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
    
    //非递归中序遍历
    public void NonRecursionInorderTraversal() {
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode node = this;
    	
    	while(!st.isEmpty()||node!=null) {//因为非递归中序有两个判断条件，所以一开始不用担心栈空进不来，也就不要压入this！
    		//LDR:先一路压倒最左下的节点
    		if(node!=null) {
    			st.push(node);
    			node = node.left;
    		}
    		//node走到最左下孩子的左子了，=null了，pop出该左子，并压入他的右子
    		else{
    			node = st.pop();
    			System.out.print(node.val+" ");
    			node = node.right;
    		}
    	}
    }
}