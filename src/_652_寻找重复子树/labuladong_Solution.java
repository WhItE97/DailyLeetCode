package _652_寻找重复子树;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class labuladong_Solution {
	/**
	 * 思路：
	 * 细化，每一个节点，应该做什么？
	 * for每一个节点：①以我为根的二叉树长啥样？？②以其他节点为根的二叉树长啥样？？
	 * HDP1.如何记录二叉树的模样？——>拼接字符串的形式把二叉树序列化！（空设置为#，否则为该节点的val）
	 * HDP2.如何存放所有节点的子树序列化结果？且我们还需要方便进行比对，是否有长得一样的序列化结果？
	 * 		——>HashSet：但是如果结果集出现多棵重复子树，HashSet只能说他又重复了，把他加入结果集（存放满足重复子树的节点的集合），最终会造成重复
	 * 		——>HashMap：用value记录其出现次数，避免结果集res中重复
	 * HDP3.遍历方式的选取——>LRD：要想知道自己为根节点的子树模样，显然先要知道自己的左子和右子的模样
	 * ATT：自己的错误理解点：traverse进行后序遍历过程中，遍历到每个点，就已经处理并比对了，不要再用一个后序遍历去调用traverse了！
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
		traverse(root);//不要忘了调用
		return res;
	}
	
	public String traverse(TreeNode node){
		//base
		if(node==null) {
			return "#";
		}
		//LRD遍历
		String left = traverse(node.left);
		String right = traverse(node.right);
		//D处理
		String subTree = left+','+right+','+node.val;//这个逗号很关键啊！！！...170/175个测试用例 就是缺了这个逗号！
		System.out.println(subTree);
		//开始试图加入hashmap
		int count = memo.getOrDefault(subTree, 0);//查找subTree key的value，如果没有，则设置default为0;count为其出现次数计数
		if(count==1) {
			//如果是第二次出现了，则将其加入res
			res.add(node);
		}
		//无论其是第几次出现，只要出现了，count都要记一次
		memo.put(subTree, count+1);
		return subTree;
	}
}
