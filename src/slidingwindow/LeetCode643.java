package slidingwindow;

/**
 * @program: Algorithm
 * @description: 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 *
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * @author: he-zx
 * @create: 2022-04-02 11:12
 **/
public class LeetCode643 {
	public double findMaxAverage(int[] nums, int k) {
	
			int sum = 0, n = nums.length;
			for (int i = 0; i < k; i++) {
				sum += nums[i];
			}
			int max = sum;
			
			for (int i = k; i < n; i++) {
				sum = sum - nums[i - k] + nums[i];
				max = Math.max(max, sum);
			}
			return (double) max / k;
	
//		//1. 初始化变量
//		double max = Double.MIN_VALUE;
//		double sum = 0;
//
//		//2. 定义窗口的首尾端
//		int start = 0;
//
//		//3. 循环
//		for (int end = 0; end < nums.length; end++) {
//			sum += nums[end];
//			if (end - start + 1 > k) {
//				sum -= nums[start];
//				start ++;
//			}
//
//			if (end - start + 1 == k) {
//				max = Math.max(max, sum / k);
//			}
//		}
//		return max;
	}

}
