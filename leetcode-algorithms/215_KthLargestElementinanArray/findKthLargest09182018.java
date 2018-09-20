class Solution {
    public int findKthLargest(int[] nums, int k){
        return quickSelect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int i = start;

        if (start < end) {
            for (int j = start; j < end; j++) {
                if (nums[j] <= pivot) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
            }
        }

        int tmp = nums[i];
        nums[i] = nums[end];
        nums[end] = tmp;

        if (i == k) {
            return nums[i];
        } else if (i < k) {
            return quickSelect(nums, k, i + 1, end);
        } else {
            return quickSelect(nums, k, start, i - 1);
        }
    }
}
