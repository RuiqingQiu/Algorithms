public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        sort(A, 0, A.length - 1);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int index = start;

        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }

        int tmp = nums[index];
        nums[index] = nums[end];
        nums[end] = tmp;

        return index;
    }

    private void sort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);

            sort(nums, start, pivot - 1);
            sort(nums, pivot + 1, end);
        }
    }
}
