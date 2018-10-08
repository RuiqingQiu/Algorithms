class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;

        if (nums == null || nums.length == 0) {
            return result;
        }

        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
