package slidingwindow;

/**
 * @program: Algorithm
 * @description: 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。\
 * 如果不存在符合条件的子数组，返回 0 。
 * @author: he-zx
 * @create: 2022-04-02 12:00
 **/
public class LeetCode209 {
	public int minSubArrayLen(int target, int[] nums) {
		int res = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0, end = 0;
		for (; end < nums.length; end++) {
			sum += nums[end];
			
			while (sum >= target) {
				res = Math.min(res, end - start + 1);
				sum -= nums[start];
				start ++;
			}
		}
		
		//如果start == 0，表示没有符合题目要求的解
		return start == 0 ? 0 : res;
	}
}
