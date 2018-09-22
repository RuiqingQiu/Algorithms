class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // Longest increasing subsequence at nums[i] (including nums[i])
        int[] dp = new int[nums.length];

        // Number of longest subsequences end here
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        int longest = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }

            longest = Math.max(longest, dp[i]);
        }

        int result = 0;

        for (int i = 0; i < count.length; i++) {
            if (dp[i] == longest) {
                result += count[i];
            }
        }

        return result;
    }
}
