class Solution:
    def xorGame(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        xor = 0
        for i in nums:
            xor ^= i

        # if xor = 0, alice win, otherwise, length of number if even, alice win
        return xor == 0 or len(nums) % 2 == 0
