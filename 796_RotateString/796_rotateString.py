class Solution:
    def rotateString(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: bool
        """
        AA = A + A
        if B in AA:
            return True
        else:
            return False
