package company.huawei;

/**
 * @program: Algorithm
 * @description:零钱兑换 II
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 * @author: he-zx
 * @create: 2022-04-08 22:28
 **/
public class LeetCode518 {
	public int change(int amount, int[] coins) {
		int[] res = new int[amount + 1];
		res[0] = 1;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i < coin) continue;
				res[i] += res[i - coin];
			}
		}
		return res[amount];
	}
}
