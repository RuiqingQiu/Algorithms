class Solution {
    public void rotate(int[] nums, int k) {
        // reverse
        int n = nums.length;

        k = k % n;

        reverse(0, n - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, n - 1, nums);
    }

    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
