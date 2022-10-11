package company.huawei;

import java.util.Arrays;

/**
 * @program: Algorithm
 * @description:合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @author: he-zx
 * @create: 2022-04-08 11:44
 **/
public class LeetCode56 {
	public int[][] merge(int[][] intervals) {
		if (intervals.length <= 1) {
			return intervals;
		}
		
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		
		int index = -1;
		int[][] res = new int[intervals.length][2];
		for (int[] interval : intervals) {
			if (index == -1 || interval[0] > res[index][1]) {
				res[++index] = interval;
			} else {
				res[index][1] = Math.max(interval[1], res[index][1]);
			}
		}
		return Arrays.copyOf(res, index + 1);
	}
}
