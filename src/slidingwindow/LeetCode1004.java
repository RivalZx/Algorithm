package slidingwindow;

/**
 * @program: Algorithm
 * @description: 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @author: he-zx
 * @create: 2022-04-06 16:20
 **/
public class LeetCode1004 {
	public int longestOnes(int[] nums, int k) {
		int l = 0, r = 0, res = 0;
		while (r < nums.length) {
			if (nums[r] == 0) {
				if (k == 0) {
					while (nums[l] == 1) l ++;
					l ++;
				} else {
					k --;
				}
			}
			res = Math.max(res, ++r - l);
		}
		return res;
	}
}
