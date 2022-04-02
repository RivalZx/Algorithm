package dynamic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Algorithm
 * @description: 每日温度
 * @author: he-zx
 * @create: 2022-04-02 15:29
 **/
public class LeetCode739 {
	
	public int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> stack = new ArrayDeque<>();
		int[] res = new int[temperatures.length];
		
		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int temp = stack.pop();
				res[temp] = i - temp;
			}
			stack.push(i);
		}
		return res;

//		超时
//		int res[] = new int[temperatures.length];
//		res[temperatures.length - 1] = 0;
//		for (int i = temperatures.length - 2; i >= 0; i++) {
//			for (int j = i + 1; j < temperatures.length; j = j + res[j]) {
//				if (temperatures[i] < temperatures[j]) {
//					res[i] = j - i;
//					break;
//				} else if (temperatures[j] == 0) {
//					res[i] = 0;
//					break;
//				}
//			}
//		}
//		return res;
	}
}
