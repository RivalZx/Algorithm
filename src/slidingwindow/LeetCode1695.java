package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: Algorithm
 * @description: 删除子数组的最大得分
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 *
 * 返回 只删除一个 子数组可获得的 最大得分 。
 *
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是a 的一个子数组。
 * @author: he-zx
 * @create: 2022-04-02 12:10
 **/
public class LeetCode1695 {
	public int maximumUniqueSubarray(int[] nums) {
		int res = 0;
		int len = nums.length;
		int sum = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for (int start = 0, end = 0;  end < len; end++) {
			if (!set.contains(nums[end])) {
				set.add(nums[end]);
				sum += nums[end];
				res = Math.max(res, sum);
			} else {
				while (nums[end] != nums[start]) {
					sum -= nums[start];
					set.remove(nums[start++]);
				}
				start ++;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		LeetCode1695 l = new LeetCode1695();
		System.out.println(l.maximumUniqueSubarray(new int[]{10000,1,10000,1,1,1,1,1,1}));
	}
}
