class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length == 0 || nums.length == 1)
            return 0;

        int max = Integer.MIN_VALUE;
        int end = -2;
        // Iterates from beginning of array
        // find the last element which is smaller than the last seen max from
        // its left side and mark it as end
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max)
                end = i;
        }

        int min = Integer.MAX_VALUE;
        int begin = -1;
        // Tterate from end of array
        // find the last element which is bigger than the last seen min from
        // its right side and mark it as begin
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                begin = i;
        }

        return end - begin + 1;
    }
}
