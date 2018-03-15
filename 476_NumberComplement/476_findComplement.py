class Solution:
    def findComplement(self, num):
        """
        :type num: int
        :rtype: int
        """
        mask = 1 << len(bin(num)) - 2
        return (mask - 1) ^ num
