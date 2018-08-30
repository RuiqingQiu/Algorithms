class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, bfs(i, j, grid, visited, 0));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int i, int j, int[][] grid, boolean[][] visited, int value) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if (grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        value += 1;

        value += bfs(i - 1, j, grid, visited, 0);
        value += bfs(i + 1, j, grid, visited, 0);
        value += bfs(i, j + 1, grid, visited, 0);
        value += bfs(i, j - 1, grid, visited, 0);

        return value;
    }
}
