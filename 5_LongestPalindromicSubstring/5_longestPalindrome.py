class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # table[i][j] will be false if substring
        # str[i..j] is not palindrome. Else
        # table[i][j] will be true
        n = len(s)
        table = [[False for _ in range(n)] for _ in range(n)]

        # All substrings of length 1 are palindromes
        maxLength = 1
        i = 0
        while i < n:
            table[i][i] = True
            i += 1

        # check for sub-string of length 2
        start = 0
        i = 0
        while i < n - 1:
            if (s[i] == s[i + 1]):
                table[i][i + 1] = True
                start = i
                maxLength = 2
            i = i + 1

        # Check for lengths greater than 2
        # k is length of substring
        k = 3
        while k <= n:
            i = 0
            while i < (n - k + 1):
                # get the end index of substring starting from i and length k
                j = i + k - 1

                # check substring from ith index to jth index iff s[i+1] to s[j-1]
                # is a palidrome
                if table[i+1][j-1] and s[i] == s[j]:
                    table[i][j] = True

                    if k > maxLength:
                        start = i
                        maxLength = k
                i += 1
            k += 1
        return s[start:start + maxLength]
