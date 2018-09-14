class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n + 2];

        for (int i = 0; i < nums.length; i++) {
            extendedNums[i + 1] = nums[i];
        }

        extendedNums[0] = 1;
        extendedNums[n + 1] = 1;

        n = n + 2;
        int[][] dp = new int[n][n];

        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;

                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], extendedNums[left] * extendedNums[i] * extendedNums[right] + dp[left][i] + dp[i][right]);
                }
            }

        }

        return dp[0][n - 1];
    }
}
