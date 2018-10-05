class Solution {
    int result = 0;

    public int maxAreaOfIsland(int[][] grid) {        
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, i, j, grid.length, grid[0].length));
                }
            }
        }

        return result;
    }

    public int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        int area = 1;

        grid[i][j] = 0;

        area += dfs(grid, i - 1, j, m, n);
        area += dfs(grid, i + 1, j, m, n);
        area += dfs(grid, i, j + 1, m, n);
        area += dfs(grid, i, j - 1, m, n);

        return area;
    }
}
