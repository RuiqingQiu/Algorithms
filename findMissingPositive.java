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
// For using O(1) space and O(n) solution
class Solution{

  public int firstMissingPositive(int[] nums){
      for(int i = 0; i < nums.length; i++){
        if(nums[i] <= 0 || nums[i] > nums.length){
            continue;
        }
        int cur = nums[i];
        int next = nums[cur-1];
        while(cur != next){
            nums[cur-1] = cur;
            cur = next;
            if(cur <= 0 || cur > nums.length){
                break;
            }
            next = nums[cur-1];
        }
      }
      for(int i = 1; i < nums.length; i++){
          if(nums[i] != i - 1){
              return i + 1;
          }
      }
      return nums.length + 1;
  }

}
