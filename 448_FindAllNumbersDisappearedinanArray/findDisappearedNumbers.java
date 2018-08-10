class Solution {
    // Using O(n) runtime and O(n) space for extra set space
    // public List<Integer> findDisappearedNumbers(int[] nums) {
    //     int n = nums.length;
    //
    //     List<Integer> result = new ArrayList<Integer>();
    //
    //     HashSet<Integer> set = new HashSet<Integer>();
    //
    //     for (int i = 0; i < nums.length; i++) {
    //         set.add(nums[i]);
    //     }
    //
    //     for (int i = 1; i <= n; i++) {
    //         if (!set.contains(i)) {
    //             result.add(i);
    //         }
    //     }
    //
    //     return result;
    // }

    // No extra space solution
    public List<Integer> findDisappearedNumbers(int [] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
