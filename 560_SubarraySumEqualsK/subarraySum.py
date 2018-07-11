class Solution:
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count = collections.Counter()
        count[0] = 1
        ans = sum = 0

        for num in nums:
            sum += num
            ans += count[sum - k]
            count[sum] += 1a

        return ans
