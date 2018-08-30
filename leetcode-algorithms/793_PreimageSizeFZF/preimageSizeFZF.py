import sys
class Solution:
    def preimageSizeFZF(self, K):
        """
        :type K: int
        :rtype: int
        """
        def findRange(K):
            low = 0
            high = sys.maxint

            while (low <= high) :
                mid = low + (high - low) / 2
                if (getZeros(mid) > K):
                    high = mid - 1
                else:
                    low = mid + 1
            return int(low) - 1

        def getZeros(N):
            count = 0
            i = 5
            while i <= N:
                count += N / i
                i *= 5
            return count

        return findRange(K) - findRange(K-1)

    
