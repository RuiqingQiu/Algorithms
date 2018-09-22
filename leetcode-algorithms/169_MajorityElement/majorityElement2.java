class Solution {
    public int majorityElement(int[] nums) {
        int majorityNumber = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majorityNumber = nums[i];
                count = 1;
            } else if (nums[i] == majorityNumber) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return majorityNumber;
    }
}
