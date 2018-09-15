public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        mergeSort(A, 0, A.length - 1);
    }

    void merge(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        int index = start;
        int[] leftArr = new int[mid - start + 1];
        int[] rightArr = new int[end - mid];

        for (int i = start; i <= mid; i++) {
            leftArr[i - start] = nums[i];
        }

        for (int i = mid + 1; i <= end; i++) {
            rightArr[i - mid - 1] = nums[i];
        }

        int left = 0;
        int right = 0;

        while (left < leftArr.length && right < rightArr.length) {
            if (leftArr[left] < rightArr[right]) {
                nums[index++] = leftArr[left++];
            } else {
                nums[index++] = rightArr[right++];
            }
        }

        while (left < leftArr.length) {
            nums[index++] = leftArr[left++];
        }

        while (right < rightArr.length) {
            nums[index++] = rightArr[right++];
        }

    }

    void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, end);
    }
}
