class Solution {
    int total = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);

        return total;
    }

    private void dfs(int[] nums, int sum, int current, int S) {
        if (current == nums.length) {
            if (sum == S) {
                total += 1;
            }
        } else {
            for (int i = -1; i <= 1; i += 2) {
                dfs(nums, sum + (i * nums[current]), current + 1, S);
            }
        }
    }
}
