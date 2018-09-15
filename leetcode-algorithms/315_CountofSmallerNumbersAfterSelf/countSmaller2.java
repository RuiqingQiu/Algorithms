class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        count = new int[nums.length];
        int[] indexes = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }

        mergesort(nums, indexes, 0, nums.length - 1);

        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }

        return result;
    }

    private void mergesort(int[] nums, int[] indexes, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }

    private void merge(int[] nums, int[] indexes, int start, int end) {
        int mid = start + (end - start) / 2;
        int left = start;
        int right = mid + 1;
        int rightCount = 0;
        int [] newIndexes = new int[end - start + 1];

        int index = 0;

        while (left <= mid && right <= end) {
            if (nums[indexes[left]] <= nums[indexes[right]]) {
                newIndexes[index] = indexes[left];
                count[indexes[left]] += rightCount;
                left++;
                index++;
            } else {
                newIndexes[index++] = indexes[right++];
                rightCount++;
            }
        }

        while (left <= mid) {
            newIndexes[index] = indexes[left];
            count[indexes[left]] += rightCount;
            left++;
            index++;
        }

        while (right <= end) {
            newIndexes[index++] = indexes[right++];
        }

        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }
}
