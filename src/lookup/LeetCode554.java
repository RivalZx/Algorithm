package lookup;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 砖墙
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 
 * @author: he-zx
 * @create: 2022-04-02 22:43
 **/
public class LeetCode554 {
	
	public int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (List<Integer> list : wall) {
			int sum = 0;
			for (Integer integer : list) {
				sum += integer;
				map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
			}
			max ++;
		}
		int col = 0;
		
		for (Integer integer : wall.get(0)) {
			col += integer;
		}
		

		int res = col;
		for (Integer t : map.keySet()) {
			if (t != col) {
				res = Math.min(col - map.get(t), res);
			}
		}
		return res;
	}
}
