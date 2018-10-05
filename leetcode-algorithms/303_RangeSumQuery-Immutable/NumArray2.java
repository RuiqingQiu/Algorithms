class NumArray {
    int[] presum;

    public NumArray(int[] nums) {
        presum = new int[nums.length + 1];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            presum[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return presum[j + 1] - presum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
