package company.huawei;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: Algorithm
 * @description: 腐烂的橘子
 * 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
 *
 * 值0代表空单元格；
 * 值1代表新鲜橘子；
 * 值2代表腐烂的橘子。
 * 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
 * @author: he-zx
 * @create: 2022-04-03 17:47
 **/
public class LeetCode994 {
	
	//使用广度优先遍历
	public int orangesRotting(int[][] grid) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		int row = grid.length;
		int col = grid[0].length;
		
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					count ++;
				}
				if (grid[i][j] == 2) {
					queue.add(new int[]{i, j});
				}
			}
		}
		
		int round = 0;
		while (count > 0 && !queue.isEmpty()) {
			round ++;
			int n = queue.size();
			
			for (int i = 0; i < n; i++) {
				int[] poll = queue.poll();
				int r = poll[0];
				int c = poll[1];
				if (r - 1 >= 0 && grid[r - 1][c] == 1) {
					grid[r - 1][c] = 2;
					count --;
					queue.add(new int[]{r - 1, c});
				}
				if (r + 1 < row && grid[r + 1][c] == 1) {
					grid[r + 1][c] = 2;
					count --;
					queue.add(new int[]{r + 1, c});
				}
				if (c - 1 >= 0 && grid[r][c - 1] == 1) {
					grid[r][c - 1] = 2;
					count --;
					queue.add(new int[]{r, c - 1});
				}
				if (c + 1 < col && grid[r][c + 1] == 1) {
					grid[r][c + 1] = 2;
					count --;
					queue.add(new int[]{r, c + 1});
				}
			}
		}
		
		if (count > 0) {
			return -1;
		} else {
			return round;
		}
	}
}
