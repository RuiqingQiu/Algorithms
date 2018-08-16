class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; i - j * j >= 0 ; j++) {
                min = Math.min(dp[i - j * j], min);
            }

            dp[i] = min + 1;
        }

        return dp[n];
    }
}
