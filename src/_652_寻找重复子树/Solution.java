package _652_寻找重复子树;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
/**
 * 思路：
 * 细化，每一个节点，应该做什么？
 * for每一个节点：①以我为根的二叉树长啥样？？②以其他节点为根的二叉树长啥样？？
 * HDP1.如何记录二叉树的模样？——>拼接字符串的形式把二叉树序列化！（空设置为#，否则为该节点的val）
 * HDP2.如何存放所有节点的子树序列化结果？且我们还需要方便进行比对，是否有长得一样的序列化结果？
 * 		——>HashSet：但是如果结果集出现多棵重复子树，HashSet只能说他又重复了，把他加入结果集（存放满足重复子树的节点的集合），最终会造成重复
 * 		——>HashMap：用value记录其出现次数，避免结果集res中重复
 * HDP3.遍历方式的选取——>LRD：要想知道自己为根节点的子树模样，显然先要知道自己的左子和右子的模样
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
		//LRD遍历所有节点，求其子树的模样，放入一个HashMap用于后续比对
		HashMap<String,Integer> memo = new HashMap<String,Integer>();
		//存放满足条件的节点的结果集(trick:linkedlist在插入和删除时具有较好性能)
		LinkedList<TreeNode> res = new LinkedList<TreeNode>();
		
		//开始LRD遍历
		postorderTraversal(memo,res,root);
		return res;
	}
	
	//用于LRD遍历
	public static void postorderTraversal(HashMap<String,Integer> memo,LinkedList<TreeNode> res,TreeNode node) {
		//base
		if(node==null) {
			return;
		}
		//LRD
		postorderTraversal(memo,res,node.left);
		postorderTraversal(memo,res,node.right);
		//D开始处理
		String s = traverse(node);
		//获取到子树后开始比对HashMap是否已有此子树
		if(memo.containsKey(s)) {
			//已经存在此子树，需要继续判断这是第几次重复，只在第二次重复将其加入res结果集
			if(memo.get(s)==1) {
				res.add(node);
				memo.put(s, memo.get(s)+1);
			}
		}
		//如果没有此子树，则加入HashMap
		else {
			memo.put(s,1);
		}
	}
	
	//输入一个节点，记录当前节点的“模样”——>即字符串拼接形式的序列化结果
	public static String traverse(TreeNode node) {
		//base
		if(node==null) {
			return "#";//空节点设置为#
		}
		
		//后序遍历记录模样LRD
		String left = traverse(node.left);
		String right = traverse(node.right);
		//D开始处理
		String res = left+","+right+","+node.val;
		return res;
	}
}
