class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        if (nums[0] > target) {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

    private int findPivot(int[] nums, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (mid < end && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (mid > start && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        }

        if (nums[start] >= nums[mid]) {
            return findPivot(nums, start, mid - 1);
        } else {
            return findPivot(nums, mid + 1, end);
        }
    }
}
