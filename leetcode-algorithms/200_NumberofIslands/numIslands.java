class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return count;
        }
        
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
        dfs(i - 1, j, grid);
    }
}
