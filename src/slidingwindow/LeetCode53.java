package slidingwindow;

/**
 * @program: Algorithm
 * @description: 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * @author: he-zx
 * @create: 2022-04-03 17:34
 **/
public class LeetCode53 {
	
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = 0;
		for (int num : nums) {
			if (sum > 0) {
				sum += num;
			} else {
				sum = num;
			}
			res = Math.max(res, sum);
		}
		return res;
	}
}
