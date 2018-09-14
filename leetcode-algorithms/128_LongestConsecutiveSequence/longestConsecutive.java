class Solution {
    public int longestConsecutive(int[] nums) {
        // Non O(n) solution
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Sort and then count
        int max = 1;
        int count = 1;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                count++;
            } else if (nums[i - 1] == nums[i]) {
                // do not increase count
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }

        max = Math.max(count, max);

        return max;
    }
}
