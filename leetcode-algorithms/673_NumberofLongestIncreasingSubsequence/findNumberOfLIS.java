class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        // length of longest ending at nums[i]
        int[] length = new int[nums.length];
        // number of longest ending in nums[i]
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[i] <= length[j]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[i] == length[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int longest = 0;

        for (int i = 0; i < length.length; i++) {
            longest = Math.max(length[i], longest);
        }

        int result = 0;

        for (int i = 0; i < count.length; i++) {
            if (length[i] == longest) {
                result += count[i];
            }
        }

        return result;
    }
}
