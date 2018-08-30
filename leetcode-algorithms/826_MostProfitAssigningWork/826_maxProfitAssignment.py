class Solution:
    def maxProfitAssignment(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """
        result = 0

        # sort in place
        lst_difficulty_profit = list(zip(difficulty, profit))
        lst_difficulty_profit.sort(key=lambda tup: tup[0])

        worker.sort()

        # index to track where in the list of jobs
        index = 0

        # keep track of the maximum profit before job level exceed ability
        maxprofit = 0

        for ability in worker:

            while index < len(lst_difficulty_profit) and ability >= lst_difficulty_profit[index][0]:
                maxprofit = max(lst_difficulty_profit[index][1], maxprofit)
                index += 1

            result += maxprofit
        return result
