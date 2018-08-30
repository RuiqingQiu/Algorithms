class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int i = 1;

        while (i < nums.length) {
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i < nums.length) {
                nums[index] = nums[i];
                index++;
            }
            i++;
        }

        return index;
    }
}
