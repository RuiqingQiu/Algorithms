//count the number of continous subarrays that is less than k
// time limit exceed naive solution, iteration two times and count
Class Solution{
  public int numSubArrayProductLessThanK(int[] nums, int k){
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for(int j = i + 1; j < nums.length; j++){
        if(SubArrayProduct(i, j, nums, k)){
          count++;
        }
      }
    }
    return count;
  }
  public boolean SubArrayProduct(int start, int end, int[] nums, int k) {
    int product = 1;
    for (int i = start; i < end; i++) {
      product *= nums[i];
      if (product >= k){
          return false;
      }
    }
    return true;
  }
}
//Sliding window solution
Class Solution{
  public int numSubArrayProductLessThanK(int[] nums, int k){
    if(k <= 1) return 0;
    int left = 0;
    int ans = 0;
    int prod = 1;
    for (int right = 0; i < nums.length; i++){
      prod *= nums[right];
      while (prod >= k) {
        prod /= nums[left++];
      }
      ans += right - left + 1;
    }
    return ans;
  }
}
