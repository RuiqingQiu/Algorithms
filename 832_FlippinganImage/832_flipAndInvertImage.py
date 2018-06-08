class Solution:
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        A = [[1 - y for y in x[::-1]] for x in A]
        return A
