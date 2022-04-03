package dynamic;

import java.util.*;

/**
 * @program: Algorithm
 * @description: 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * @author: he-zx
 * @create: 2022-04-02 12:49
 **/
public class LeetCode15 {
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3)
			return res;
		
		Arrays.sort(nums);
		int l, r;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				return res;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			l = i + 1;
			r = nums.length - 1;
			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == 0) {
					res.add(Arrays.asList(nums[i], nums[l], nums[r]));
					while (l < r && nums[l] == nums[l + 1]) {
						l ++;
					}
					while (l < r && nums[r] == nums[r - 1]) {
						r --;
					}
					l ++;
					r --;
				} else if (nums[i] + nums[l] + nums[r] > 0) {
					r --;
				} else {
					l ++;
				}
			}
		}
		return res;
	}
}
