public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        sort(A, 0, A.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);

            sort(nums, start, pivot - 1);
            sort(nums, pivot + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }

        int tmp = nums[i];
        nums[i] = nums[end];
        nums[end] = tmp;

        return i;
    }
}
