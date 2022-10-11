package company.huawei;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description:II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * @author: he-zx
 * @create: 2022-04-08 11:52
 **/
public class Offer57 {
	public int[][] findContinuousSequence(int target) {
		List<int[]> res = new ArrayList<>();
		int start = 1, end = 1, sum = 0;
		while (start <= target / 2) {
			if (sum < target) {
				sum += end;
				end ++;
			} else if (sum > target) {
				sum -= start;
				start ++;
			} else {
				int[] add = new int[end - start];
				for (int i = 0; i < end - start; i++) {
					add[i] = start + i;
				}
				res.add(add);
				sum -= start;
				start ++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}
}
