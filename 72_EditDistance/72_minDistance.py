class Solution:
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        m = len(word1)
        n = len(word2)

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = i

        for i in range(1, n + 1):
            dp[0][i] = i

        for i in range(m):
            for j in range(n):
                if word1[i] == word2[j]:
                    dp[i + 1][j + 1] = dp[i][j]
                else:
                    a = dp[i][j]
                    b = dp[i][j + 1]
                    c = dp[i + 1][j]
                    dp[i + 1][j + 1] = min(min(a, b), c)
                    dp[i + 1][j + 1] += 1
        return dp[m][n]
