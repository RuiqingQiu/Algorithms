class Solution {
    // O(n^2)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }

            result.add(count);
        }

        return result;
    }
}
