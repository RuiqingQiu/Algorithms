class Solution:
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        current_sum = 0
        diff_map = {0: -1}
        result = 0

        for index, num in enumerate(nums):
            current_sum += num

            if current_sum not in diff_map:
                diff_map[current_sum] = index

            if current_sum - k in diff_map:
                result = max(result, index - diff_map[current_sum - k])

        return result
