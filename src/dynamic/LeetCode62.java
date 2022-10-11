package dynamic;

/**
 * @program: Algorithm
 * @description:
 * @author: he-zx
 * @create: 2022-10-09 22:18
 **/
public class LeetCode62 {
		public int uniquePaths(int m, int n) {
			int[][] memo = new int[m - 1][n - 1];
			memo[0][0] = 1;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (i == 0 || j == 0)
						memo[i][j] = 1;
					else
						memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
				}
			}
			return memo[m - 1][n - 1];
		}
}
