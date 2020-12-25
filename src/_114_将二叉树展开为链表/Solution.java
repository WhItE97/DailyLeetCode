package _114_将二叉树展开为链表;

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
	 * 法一：labuladong的递归框架
	 * 思路：
	 * 1.要实现变成单链表：第一步把root的左右子树分别抹平成全为右子的单链表；第二步调整两个子树的位置即可
	 * 2.所以，由函数flatten的目标，对其功能下一个定义：输入节点抹平成一个单链表
	 * 3.所以，直接调用flatten递归处理root的左右子树即可（不要跳进递归细节，即不要care flatten具体怎么work的，相信他！）
	 * 4.最后对flatten结束的左右子树，root进行位置的调整（右子接到左子末尾后，左子整个变右子）即可
	 */
	public void flatten(TreeNode root) {
		//base
		if(root==null) {
			return;
		}
		//不管flatten怎么work的，反正他的定义就是抹平该节点成为一个单链表
		//（不要去跳进递归的细节！！）
		//所以对root的左右子树递归即可
		flatten(root.left);
		flatten(root.right);
		
		//递归完后，其左子和右子已经都抹平了，处理root的左右子，连成一个单链表即可(画图理解)
		TreeNode right = root.right;
		root.right =  root.left;
		root.left = null;
		//递归找到末尾，再连上之前的right
		while(root.right!=null) {
			root = root.right;
		}
		root.right = right;
	}
	
	/**
	 * 法二：理解原理的写法
	 * 思路：
	 * 不难发现，抹平成单链表后的顺序，就是对原二叉树前序遍历的顺序
	 * 所以对二叉树进行前序遍历，然后拿个list去装节点即可
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
			root.left = null;//注意记得清空左子树！
			root = root.right;//并且要把右子树迭代起来！别一直重复插在root上啊..！！
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
