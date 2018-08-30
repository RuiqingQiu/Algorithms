class Solution:
    def racecar(self, target):
        """
        :type target: int
        :rtype: int
        """
        dp = [0] + [float('inf')] * target
        for i in range(1, target + 1):
            n = i.bit_length()

            # case 1. drive exactly to the target
            if i == 2 ** n - 1:
                dp[i] = n
                continue

            # case 2. drive past the target and reverse all the way back
            dp[i] = dp[2**n - 1 - i] + n + 1

            # case 3. drive less than 2 ^ (n - 1) then turn back some distance,
            # turn back again to make the direction correct
            #         seq(i) = shortest(seq(i), A^(k-1) -> R -> A^j -> R ->
            #                                   seq(i - (2^(k-1)-1) + (2^j-1)),
            #                  where 0 <= j < k-1)
            #         => dp[i] = min(dp[i], (k-1) + 1 + j + 1 +
            #                               dp[i - (2**(k-1)-1) + (2**j-1)])
            for m in range(n - 1):
                dp[i] = min(dp[i], dp[i - 2 ** (n - 1) + 2 ** m] + n + m + 1)

        return dp[target]
