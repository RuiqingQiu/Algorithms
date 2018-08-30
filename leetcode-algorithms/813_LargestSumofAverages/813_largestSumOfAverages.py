import sys

class Solution:
    def largestSumOfAverages(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: float
        """
        L = len(A)
        dp = [[0] * (K + 1) for i in range(L)]
        s = [0] * (L + 1)
        s[0] = 0

        for i in range(1, L + 1):
            s[i] = s[i - 1] + A[i - 1]
            dp[i - 1][1] = s[i] / i

        for j in range(2, K + 1):
            for i in range(0, L):
                val = max([dp[p][j - 1] + (s[i + 1] - s[p + 1]) / (i - p) for p in range(0, i)] or [0])
                dp[i][j] = val
        return dp[L - 1][K]
