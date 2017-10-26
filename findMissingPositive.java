class Solution{

  public int firstMissingPositive(int[] nums){
      int j = 0;
      for(int i = 0; i < nums.length; i++){
         if(nums[i] <= 0){
             int tmp = nums[i];
             nums[i] = nums[j];
             nums[j] = nums[i];
             j++;
         }
      }
      int size = nums.length - j - 1;
      int [] test_arr = new int[size];
      for(int i = j; i < nums.length; i++){
        if(nums[i] <= size){
            test_arr[nums[i]-1] = -1; 
        }
      }
      for(int i = 0; i < size; i++){
        if(test_arr[i] >= 0){
            return i + 1; 
        }
      }
      return size + 1;
  }

}
