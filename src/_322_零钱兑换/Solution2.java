package _322_零钱兑换;

public class Solution2 {
/**
 * 动态规划解法2：自下而上的dp（类似优化后的Fibonacci）
 * 状态转移方程：
 * f(s) = f(s-coin) + 1
 * f(s) = min{traverse coin:f(s-coin)} + 1
 * 
 * 自下而上，所以要一个for循环从f(0)开始计算dp！
 */
/** 思路总结：
 * 1.“最少的硬币个数”——>动态规划最优解
 * （DP题型 判断依据：动态规划三要素[重叠子问题、最优子结构、状态转移方程]）
 * 2.动态规划关键分析点：
 * （1）状态：原问题和子问题中会变化的点——>amount
 * （2）选择：导致状态变化的行为——>coins
 * （3）【IMP HDP】确定状态转移方程——>f(s)=f(s-coin)+1
 * //f(s):金额s的最少硬币数；coin：遍历所有可选择的coins面额
 * 3.自底向上计算，减少重复计算，提升效率！
 * 用到int[] count = new int[amount+1]//该数组用于存放自底向上求得的下标对应的金额
 * 所求得的最少硬币数！
 * 4.for(int i=1;i<=amount;i++)
 *     for(int coin:coins)
 * 第一个用于自底向上求解的遍历（每一个大轮都要求出一个最小值，如果无解则置为-1！）
 * 第二个for用于每一个amount都要进行一次coins的枚举（枚举过程注意判断当前amount
 * 是否还足够枚举该coin——>不然访问count[i-coin]会越界！）
 */
	public int coinChange(int[] coins,int amount) {
		if(amount<1) {
			return 0;
		}
		return dp(coins,amount,new int[amount+1]);
	}
	
	public int dp(int[] coins,int amount,int[] count) {
		for(int i=1;i<=amount;i++) {//从f(1)开始自底向上计算dp
			int min = Integer.MAX_VALUE;
			//对每一轮f都要枚举所有的coin选择，并得到一个f(s-coin)
			for(int coin:coins) {
				if((i-coin)<0) {//amount已经不够该面额了，所以跳过该面额
					continue;
				}
				//DIFF!!!!由于自底向上，所以可以在f(amount-coin)上+1；特殊！如果f(amount-coin)为-1，则也得返回-1
				int res = count[i-coin]>=0?Math.min(min, count[i-coin]+1):-1;//这里count全初始化为0了..判断可能有错
				if(res>=0&&res<min) {//如果该条路走得通，且硬币数小于min，则替换！
					min = res;
				}
			}
			count[i] = (min==Integer.MAX_VALUE)?-1:min;
		}
		return count[amount];
	}
}
