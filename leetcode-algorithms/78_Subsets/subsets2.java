class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> lst, int[] nums, int start) {
        result.add(new ArrayList(lst));

        for (int i = start; i < nums.length; i++) {
            lst.add(nums[i]);
            backtrack(result, lst, nums, i + 1);
            lst.remove(lst.size() - 1);
        }
    }
}
