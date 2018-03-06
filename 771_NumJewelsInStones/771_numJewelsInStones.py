from collections import defaultdict

class Solution(object):
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        stoneCount = defaultdict(int)
        for stone in S:
            stoneCount[stone] += 1

        count = 0
        for jewel in J:
            count += stoneCount[jewel]
        return count
