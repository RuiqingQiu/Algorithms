class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                int i = mid;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }

                int j = mid;
                while (j <= nums.length - 1 && nums[j] == target) {
                    j++;
                }

                result[0] = i + 1;
                result[1] = j - 1;

                return result;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
