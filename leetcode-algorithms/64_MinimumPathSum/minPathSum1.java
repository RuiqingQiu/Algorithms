// Brute force time limit exceed
class Solution {
    int min = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        helper(0, 0, m, n, 0, grid);

        return min;
    }

    public void helper(int i, int j, int m, int n, int current, int[][] grid) {
        if (i >= m || j >= n) {
            return;
        }

        if (i == m - 1 && j == n - 1) {
            min = Math.min(current + grid[i][j], min);
            return;
        } else {
            helper(i + 1, j, m, n, current + grid[i][j], grid);
            helper(i, j + 1, m, n, current + grid[i][j], grid);
        }
    }
}
