class Solution {
  public int findKthLargest(int[] nums, int k){
      // quick select
      int n = nums.length;
      int pivot = quickSelect(nums, 0, n - 1, n - k + 1);

      return nums[pivot];
  }

  private int quickSelect(int[] nums, int low, int high, int k) {
      int i = low;
      int j = high;
      int pivot = nums[high];

      while (i < j) {
          if (nums[i++] > pivot) {
              swap(nums, --i, --j);
          }
      }

      swap(nums, i, high);

      int m = i - low + 1;

      if (m == k) {
          return i;
      } else if (m > k) {
          return quickSelect(nums, low, i - 1, k);
      } else {
          return quickSelect(nums, i + 1, high, k - m);
      }
  }

  private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
  }
}
