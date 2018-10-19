class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> lst, int[] nums, int start) {
        result.add(new ArrayList<Integer>(lst));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            lst.add(nums[i]);
            backtrack(result, lst, nums, i + 1);
            lst.remove(lst.size() - 1);
        }
    }
}
