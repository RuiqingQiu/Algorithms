class Solution:
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        uniqueCandies = set(candies)
        return min(len(uniqueCandies), int(len(candies) / 2))
