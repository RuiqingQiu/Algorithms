class Solution:
    def numSubarrayBoundedMax(self, A, L, R):
        """
        :type A: List[int]
        :type L: int
        :type R: int
        :rtype: int
        """
        j = 0
        result = 0
        count = 0
        for i in range(len(A)):
            # within the range, update the count so that it has the correct number of
            # subarray for elements whose values is less than the range
            if (A[i] >= L and A[i] <= R):
                count = i - j + 1
                result += count
            # if the current number is less than range, then added count number of subarray to result
            # since it produces the same number of subarray by adding it to the end
            elif (A[i] < L):
                result += count
            # if the number if larger than the range, we need to restart counting 
            else:
                j = i + 1
                count = 0
        return result
