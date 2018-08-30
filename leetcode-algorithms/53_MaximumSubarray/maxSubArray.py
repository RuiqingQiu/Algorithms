class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_end_here = nums[0]
        max_so_far = nums[0]

        for num in nums[1:]:
            max_end_here = max(max_end_here + num, num)
            max_so_far = max(max_end_here, max_so_far)

        return max_so_far
