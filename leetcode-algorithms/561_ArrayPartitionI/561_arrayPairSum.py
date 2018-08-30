class Solution:
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        nums.sort()
        i = 0
        while i < len(nums):
            result += nums[i]
            # skip the next one
            i += 2
        return result
            
