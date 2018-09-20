class Solution {
    public int lengthOfLIS(int[] nums) {
        //dp[i] = longest increasing subsequence length including nums[i]
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int result = 1;

        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
