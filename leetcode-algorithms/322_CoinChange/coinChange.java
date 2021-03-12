class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        int sum = 1;

        while (sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int tmp = dp[sum - coin] + 1;
                    min = min < 0 ? tmp : (tmp < min ? tmp : min);
                }
            }
            dp[sum] = min;
            sum++;
        }

        return dp[amount];
    }
}
