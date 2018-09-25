class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count += 1;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add (i * grid[0].length + j);
        grid[i][j] = '0';

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / grid[0].length;
            int y = current % grid[0].length;


            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.add((x - 1) * grid[0].length + y);
                grid[x - 1][y] = '0';
            }

            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                queue.add((x + 1) * grid[0].length + y);
                grid[x + 1][y] = '0';

            }

            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.add(x * grid[0].length + y - 1);
                grid[x][y - 1] = '0';

            }

            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                queue.add(x * grid[0].length + y + 1);
                grid[x][y + 1] = '0';
            }
        }
    }
}
