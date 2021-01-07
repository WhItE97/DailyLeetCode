package _322_零钱兑换;

public class Solution {
/**
 * 题目：
 * 给定不同面额的硬币coins和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @param coins：存放了不同的硬币面额
 * @param amount：总金额
 * @return：凑成总金额所需的最少硬币数；if凑不出，返回-1
 */
/**
 * 思路：
 * “最少”——>最优解问题——>动态规划——>三要素：①重叠子问题②最优子结构③状态转移方程
 * steps：
 * 1.明确base case
 * 2.明确【状态】（原问题和子问题中会变化的变量）
 * 3.明确【选择】（导致状态变化的行为）
 * 4.定义dp数组/函数的含义
 */
	public int coinChange(int[] coins,int amount) {
		/**
		 * 本题的1.状态：amount，2.选择：不同的coin面额
		 * HDP：写出状态转移方程
		 * 思路：
		 * 设f（s）为组成amount金额的最少硬币数
		 * 则f（s） = f（s-c）+1；
		 * 其中c为硬币面额，所以这里需要枚举所有可能的硬币面额
		 * 无论这一次的c取面额为多少，硬币数都+1，所以就转化为求解最优子结构！
		 * 
		 * eg：
		 * coins=[1,2,5]
		 * f（6）=min{f(6-1),f(6-2),f(6-5)}+1
		 * 而f（5）=min{f(5-1),f(5-2),f(5-5)}+1
		 * 所以会出现很多重复运算的节点！（类似之前的Fibonacci递归）
		 * 所以用一个dp数组记录下每个节点的最少硬币数，每次用到某个节点时先查数组，没有再计算、更新
		 */
		//先采用自上而下计算写一遍
		if(amount<1) {
			return 0;//初始金额<1，则只有0种方案
		}
		return coinChange(coins,amount,new int[amount+1]);//初始化dp数组为amount+1，是为了方便对应，其第0号位元素不管
	}
	/**
	 * @param coins:所有的硬币面额
	 * @param amount:当前额度（每轮选择后都会变化的[状态]）
	 * @param dp:组成对应下标amount所需最少的硬币数
	 * @return:
	 */
	private int coinChange(int[] coins,int amount,int[] dp) {
		//别忘了迭代的base..
		if(amount<0) {
			return -1;//迭代中因为amount每轮都在枚举-coin，所以可能<0，这种情况即此条路无解，return -1
		}
		if(amount==0) {
			return 0;//为0说明本条路走到头了，amount恰好==0，不需要再追加硬币数了，所以return 0
		}
		//【自上而下的KEY POINT：先查dp表，有无对应值！有就别算了！】！！！！！！！！！！！！！！！！！没有这步这里的dp表就没意义了！也会超时！！！！
		if(dp[amount]!=0) {
			return dp[amount];
		}
		int min = Integer.MAX_VALUE;//用于装一轮dp选择，所有不同coin对应的硬币数的最小值
		for(int coin:coins) {//对本轮dp（dp[amount]）遍历所有coin选项，求最优解
			int res = coinChange(coins,amount-coin,dp);//每一轮求选择该coin对应的硬币数，对返回值进行讨论
			//res必须>=0才意味着有解，而每轮遍历所有coin不只要求有解，还要最优解min！
			//如果无解或者并不小于min，那就没必要更新dp[amount]
			if(res>=0&&res<min) {
				//得到了一个更优解，更新dp数组
				min = res+1;//res是去掉本轮的硬币的最优解，于本轮而言，还要count这一枚硬币
			}
		}
		dp[amount] = (min==Integer.MAX_VALUE)?-1:min;//遍历完dp[amount]这轮的所有选择后，还需要检查min是否改变！如果没变说明无解！
		return dp[amount];
	}
}
