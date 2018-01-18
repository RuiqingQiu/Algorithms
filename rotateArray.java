class Solution {

  // Method 1
  public void rotate(int [] nums, int k) {
    reverse(nums, 0, nums.length);
    reverse(nums, k, nums.length);
  }

  public void reverse(int [] nums, int start, int end) {
    for (int i = start ; i < end / 2; i++) {
      nums[i] = nums[end - i - 1];
    }
  }

  // Method 2
  
}
