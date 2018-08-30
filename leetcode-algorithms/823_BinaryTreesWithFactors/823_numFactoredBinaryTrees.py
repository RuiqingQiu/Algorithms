class Solution:
    def numFactoredBinaryTrees(self, A):
        """
        :type A: List[int]
        :rtype: int
        """

        # dynamic programming problem
        # dp[i] = how many binary tree we can make at node i
        # recursive subproblem dp[i] = dp[j] * dp[i / j] if i % j == 0 and i / j in A
        A.sort()

        dp = {}
        for i in range(len(A)):
            dp[A[i]] = 1
            for j in range(i):
                if A[i] % A[j] == 0 and A[i] / A[j] in dp:
                    dp[A[i]] += dp[A[j]] * dp[A[i] / A[j]]
        return sum(dp.values()) % (10 ** 9 + 7)
