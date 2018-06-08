class Solution:
    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        start = end = 0

        res = []
        
        while end < len(S):
            while end < len(S) and S[start] == S[end]:
                end += 1
            if end - start >= 3:
                res.append([start, end - 1])
            start = end

        return res
