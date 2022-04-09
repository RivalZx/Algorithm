package everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Algorithm
 * @description: 行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
 * 如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * @author: he-zx
 * @create: 2022-04-07 12:48
 **/
public class LeetCode735 {
	public int[] asteroidCollision(int[] asteroids) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < asteroids.length; i++) {
			int cur = asteroids[i];
			boolean add = true;
			while (!stack.isEmpty() && cur < 0 && stack.peek() > 0) {
				if (Math.abs(cur) == stack.peek()) {
					add = false;
					stack.pop();
					break;
				} else if (Math.abs(cur) > stack.peek()) {
					stack.pop();
				} else {
					add = false;
					break;
				}
			}
			if (add) stack.push(cur);
		}
		
		int[] res = new int[stack.size()];
		int pos = res.length - 1;
		while (pos >= 0) {
			res[pos--] = stack.pop();
		}
		return res;
	}
}
