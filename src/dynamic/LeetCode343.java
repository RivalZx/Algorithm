package dynamic;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-09 20:49
 **/
public class LeetCode343 {
	private int[] memo;
	
	public int integerBreak(int n) {
		memo = new int[n + 1];
		return breakInteger(n);
	}
	
	
	
	// 至少分割n一次，返回分割后的最优解
	private int breakInteger(int n) {
		if (n == 1)
			return 1;
		if (memo[n] != 0)
			return memo[n];
		
		for (int i = 1; i <= n - 1; i++) {
			memo[n] = Math.max(memo[n], Math.max(i * breakInteger(n - i), i * (n - i)));
		}
		return memo[n];
	}
	
	
}
