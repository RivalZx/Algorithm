package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 全排列2
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @author: he-zx
 * @create: 2022-03-29 15:36
 **/
public class LeetCode47 {
	
	List<List<Integer>> res = new ArrayList<>();
	boolean[] use;
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null) {
			return res;
		}
		Arrays.sort(nums);
		use = new boolean[nums.length];
		helper(nums, 0, new ArrayList<Integer>());
		return res;
	}
	
	private void helper(int[] nums, int index, List<Integer> temp) {
		//递归终止条件
		if (index == nums.length) {
			List<Integer> a = new ArrayList<>(temp);
			res.add(a);
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (use[i] || (i > 0 && nums[i] == nums[i - 1] && !use[i - 1])) {
				continue;
			}
			temp.add(nums[i]);
			use[i] = true;
			helper(nums, index + 1, temp);
			temp.remove((Integer) nums[i]);
			use[i] = false;
		}
	}
	
}
