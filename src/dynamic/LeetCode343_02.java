package dynamic;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-09 21:09
 **/
public class LeetCode343_02 {
	public int integerBreak(int n) {
		int[] memo = new int[n + 1];
		memo[1] = 1;
		// memo[i]表示i这个数字能够获得最优解
		for (int i = 2; i <= n; i++) {
			// 数字i能被拆分成 (i - j) * j
			for (int j = 1; j <= i - 1; j ++) {
				memo[i] = Math.max(Math.max(memo[i], j * (i - j)), j * memo[i - j]);
			}
		}
		return memo[n];
	}
}
