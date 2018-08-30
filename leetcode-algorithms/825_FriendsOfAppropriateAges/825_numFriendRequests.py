from bisect import bisect_left, bisect_right

class Solution:
    def numFriendRequests(self, ages):
        """
        :type ages: List[int]
        :rtype: int
        """
        total = 0
        ages.sort()

        for i in range(len(ages)-1, -1, -1):
            a = ages[i]
            r = bisect_right(ages, a) - 1
            l = bisect_right(ages, a / 2 + 7)
            if r - l >= 0:
                total += (r - l)
        return total
