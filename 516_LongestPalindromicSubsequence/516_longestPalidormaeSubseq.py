class Solution:
    # time limit exceeded
    # def longestPalindromeSubseq(self, s):
    #     """
    #     :type s: str
    #     :rtype: str
    #     """
    #     n = len(s)
    #     dp = [[0 for x in range(n)] for x in range(n)]
    #
    #     for i in range(n):
    #         dp[i][i] = 1
    #
    #     for cl in range(2, n + 1):
    #         for i in range(n - cl + 1):
    #             j = i + cl - 1
    #             if s[i] == s[j] and cl == 2:
    #                 dp[i][j] = 2
    #             elif s[i] == s[j]:
    #                 dp[i][j] = dp[i + 1][j - 1] + 2
    #             else:
    #                 dp[i][j] = max(dp[i][j-1], dp[i+1][j])
    #     return dp[0][n-1]

    def longestPalindromeSubseq(self, s):
        dp = []
        for i in range(len(s)):
            dp.append([0] * len(s))

        i = len(s) - 1
        while i >= 0:
            dp[i][i] = 1
            j = i + 1
            while j < len(s):
                if s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1] + 2
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
                j += 1
            i -= 1
        return dp[0][len(s) - 1]

    # O(n) space solution
    def longestPalindromeSubseq(self, s):
        n = len(s)
        dp = [1] * n
        for j in xrange(1, len(s)):
            pre = dp[j]
            for i in reversed(xrange(0, j)):
                tmp = dp[i]
                if s[i] == s[j]:
                    dp[i] = 2 + pre if i + 1 <= j - 1 else 2
                else:
                    dp[i] = max(dp[i + 1], dp[i])
                pre = tmp
        return dp[0]
