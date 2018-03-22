class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        # recursive solution
        # if not p:
        #     return not s
        #
        # first_match = bool(s) and p[0] in {s[0], '.'}
        #
        # if len(p) >= 2 and p[1] == '*':
        #     return (self.isMatch(s, p[2:])) or (first_match and self.isMatch(s[1:], p))
        # else:
        #     return first_match and self.isMatch(s[1:], p[1:])

        # dynamic programming

        # dp[0][0] means the match status of two empty strings
        # dp[1][1] means the match status of p[0] and s[0]
        # dp[i][j] means the match status of p[:i] and s[:j]

        # init the table with False
        dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]

        # corner case for two empty string
        dp[0][0] = True

        for i in range(2, len(p) + 1):
            dp[i][0] = dp[i-2][0] and p[i-1] == '*'

        for i in range(1, len(p) + 1):
            for j in range(1, len(s) + 1):
                if p[i-1] != "*":
                    dp[i][j] = dp[i-1][j-1] and (p[i-1] == s[j-1] or p[i-1] == '.')
                else:
                    dp[i][j] = dp[i-2][j] or dp[i-1][j]

                    if p[i-2] == s[j-1] or p[i-2] == '.':
                        dp[i][j] |= dp[i][j-1]
        return dp[-1][-1]
