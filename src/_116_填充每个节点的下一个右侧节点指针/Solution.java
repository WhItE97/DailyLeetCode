package _116_填充每个节点的下一个右侧节点指针;

public class Solution {
/**
 * 题目：
 * 给定一个完美二叉树，其所有叶子在同一层，每个父节点都有两个子节点
 * 填充它的每个next指针，使其指向下一个右侧节点；如果找不到，则next置为null
 * 
 * 思路：
 * 如果同之前“二叉树问题难点在于，如何把题目要求细化为每个节点要做的事情”的思路，把每个节点的左子连到右子
 * 不能实现同层中非同一个父节点（跨父节点）的两个节点之间的连接（左节点的右儿子和右节点的左儿子）！
 * so, change
 * “细化为每一个节点不行”——>那就增加函数参数！一个节点不够，就给他安排两个节点！
 * 目标由“把每一层二叉树节点连接起来”细化为“将每两个相邻节点都连接起来”
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
		//不要忘了base..！！！
		if(node1==null) {//因为是满二叉树，所以随便一个左子or右子为null，他都结束了
			return;
		}
		
		//先把他们俩连起来
		node1.next = node2;
		//再分别连他们自己的左右子
		connectTwo(node1.left,node1.right);
		connectTwo(node2.left,node2.right);
		//还要连他们俩相接的儿子
		connectTwo(node1.right,node2.left);
	}
}
