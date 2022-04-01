package greedy;

import dynamic.LeetCode46;

/**
 * @program: Algorithm
 * @description: 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 * @author: he-zx
 * @create: 2022-03-31 21:23
 **/
public class LeetCode45 {
	public int jump(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return 0;
		}
		
		int k = 0, end = 0, step = 0;
		
		for (int i = 0; i < len; i++) {
			k = Math.max(k, i + nums[i]);
			
			if (k >= len - 1) {
				return step + 1;
			}
			
			if (end == i) {
				step ++;
				end = k;
			}
		}
		
		return step;
	}
	
	public static void main(String[] args) {
		LeetCode45 l = new LeetCode45();
		int i = l.jump(new int[]{2, 3, 1, 1, 4});
		System.out.println(i);
		
	}
}
