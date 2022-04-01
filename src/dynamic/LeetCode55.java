package dynamic;

/**
 * @program: Algorithm
 * @description: 跳跃游戏
 * @author: he-zx
 * @create: 2022-04-01 15:54
 **/
public class LeetCode55 {
	public boolean canJump(int[] nums) {
		if (nums.length == 1) {
			return true;
		}
		//目前到达的最远距离的索引
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, i + nums[i]);
			if (max >= nums.length - 1) {
				return true;
			}
			
			if (i == max) {
				return false;
			}
		}
		
		return false;
	}
}
