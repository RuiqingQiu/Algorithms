class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        backtrack(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start) {
        result.add(new ArrayList(tmpList));

        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtrack(result, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
