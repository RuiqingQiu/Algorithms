class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int duplicate = -1;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                duplicate = nums[i];
            }

            sum += nums[i];
        }

        int right_sum = (1 + nums.length) * nums.length / 2;
        int missing = duplicate + (right_sum - sum);

        int[] result = new int[]{duplicate, missing};

        return result;
    }
}
