
//1D Dynamic programming
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];


        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 >= m && j + 1 >= n) {
                    dp[j] = grid[i][j];
                } else if (i + 1 >= m) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j + 1 >= n) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + grid[i][j];
                }
            }
        }

        return dp[0];
    }
}
