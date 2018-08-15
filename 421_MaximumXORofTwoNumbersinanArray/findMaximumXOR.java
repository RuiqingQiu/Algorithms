class Solution {
    public int findMaximumXOR(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int current = nums[i] ^ nums[j];
                max = Math.max(current, max);
            }
        }

        return max;
    }
}
