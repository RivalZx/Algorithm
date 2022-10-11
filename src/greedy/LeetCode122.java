package greedy;

/**
 * @program: Algorithm
 * @description:
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。
 * @author: he-zx
 * @create: 2022-08-31 21:42
 **/
public class LeetCode122 {
	
	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 1; i < prices.length - 1; i++) {
			int cur = prices[i] - prices[i - 1];
			if (cur > 0) res += cur;
		}
		return res;
	}

}
