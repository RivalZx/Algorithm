package recursion;

public class LeetCode105 {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] visit = new int[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res = Math.max(res, DFS(grid, visit, i, j));
            }
        }
        return res;
    }

    private int DFS(int[][] grid, int[][] visit, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visit[i][j] == 1 || grid[i][j] == 0)
            return 0;
        visit[i][j] = 1;
        return 1 + DFS(grid, visit, i - 1, j) + DFS(grid, visit, i + 1, j) + DFS(grid, visit, i, j - 1) + DFS(grid, visit, i, j + 1);
    }
}

