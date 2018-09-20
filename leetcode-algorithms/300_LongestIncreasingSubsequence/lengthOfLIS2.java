class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int result = 0;

        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, result, num);

            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = num;

            if (index == result) {
                result++;
            }
        }

        return result;
    }
}
