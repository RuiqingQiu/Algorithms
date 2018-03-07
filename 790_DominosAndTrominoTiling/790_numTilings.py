class Solution:
    def numTilings(self, N):
        """
        :type N: int
        :rtype: int
        """
        dp = []
        if N <= 3:
            dp = [0] * 4
        else:
            dp = [0] * (N + 1)
            
        mod = 10**9 + 7
        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        dp[3] = 5

        for i in range(4, N + 1):
            dp[i] = ((dp[i - 1] * 2) % mod + dp[i - 3]) % mod
        return dp[N]
