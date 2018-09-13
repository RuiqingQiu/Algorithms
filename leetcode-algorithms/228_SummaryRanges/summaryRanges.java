class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        int i = 0;
        int j = 1;

        while (i < nums.length) {
            while (j < nums.length && nums[j] - nums[j - 1] == 1) {
                j++;
            }
            if (i == j - 1) {
                result.add("" + nums[i]);
            } else {
                result.add("" + nums[i] + "->" + nums[j - 1]);
            }
            i = j;
            j = j + 1;
        }

        return result;
    }
}
