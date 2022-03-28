package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Algorithm
 * @description: N皇后 II
 * n皇后问题 研究的是如何将 n个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 *
 * @author: he-zx
 * @create: 2022-03-28 10:30
 **/
public class LeetCode52 {
	int res;
	public int totalNQueens(int n) {
		int[] col = new int[n];
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		helper(col, map1, map2, 0, n);
		return res;
	}
	
	private void helper(int[] col, Map<Integer, Integer> map1, Map<Integer, Integer> map2, int i, int n) {
		if (i == n) { //放完了所有的皇后
			res ++;
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if (col[j] == 0 && map1.get(j - 1) == null && map2.get(j + 1) == null) {
				col[j] = 1;
				map1.put(i - j, 1);
				map2.put(i + j, 1);
				helper(col, map1, map2, i + 1, n);
				col[j] = 0;
				map1.remove(i - j);
				map2.remove(i + j);
			}
		}
	}
	
	
}
