class Solution:
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """

        result = sums = 0

        diff_map = {0: -1}

        for index, num in enumerate(nums):
            sums += num

            if sums not in diff_map:
                diff_map[sums] = index

            if sums - k in diff_map:
                result = max(result, index - diff_map[sums-k])

        return result
