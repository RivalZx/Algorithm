package company.huawei;

/**
 * @program: Algorithm
 * @description: 小岛问题
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 
 * @author: he-zx
 * @create: 2022-04-06 16:02
 **/
public class LeetCode200 {
	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				inject(grid, i, j);
				res ++;
			}
		}
		return res;
	}
	
	private void inject(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '2';
		inject(grid, i - 1, j);
		inject(grid, i + 1, j);
		inject(grid, i, j - 1);
		inject(grid, i, j + 1);
	}
	
	
}
