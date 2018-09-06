class Solution {

    // Space O(1)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prevMax = 0;
        int currentMax = 0;

        for (int num : nums) {
            int tmp = currentMax;
            currentMax = Math.max(prevMax + num, currentMax);
            prevMax = tmp;
        }

        return currentMax;
    }
}
