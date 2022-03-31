package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author: he-zx
 * @create: 2022-03-29 15:01
 **/
public class LeetCode46 {
	
	List<List<Integer>> res = new ArrayList<>();
	boolean[] use;
	
	public List<List<Integer>> permute(int[] nums) {
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
			if (use[i]) {
				continue;
			}
			temp.add(nums[i]);
			use[i] = true;
			helper(nums, index + 1, temp);
			temp.remove((Integer) nums[i]);
			use[i] = false;
		}
	}
	
	public static void main(String[] args) {
		LeetCode46 l = new LeetCode46();
		l.permute(new int[]{1, 2, 3});
	}
}
