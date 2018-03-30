class Solution:
    def hasAlternatingBits(self, n):
        """
        :type n: int
        :rtype: bool
        """
        binary = bin(n)[2:]
        return all(binary[i] != binary[i + 1] for i in range(len(binary) - 1))
