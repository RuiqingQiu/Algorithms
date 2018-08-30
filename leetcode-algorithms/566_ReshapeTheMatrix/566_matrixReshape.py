from functools import reduce

class Solution:
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        if r * c != len(nums) * len(nums[0]):
            return nums

        straight_lst = reduce(lambda x, y: x + y, nums)
        return [[straight_lst[i * c + j] for j in range(c)] for i in range(r)]
