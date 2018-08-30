class Solution:
    def champagneTower(self, poured, query_row, query_glass):
        """
        :type poured: int
        :type query_row: int
        :type query_glass: int
        :rtype: float
        """
        result = [[0] * k for k in range(1, 102)]
        result[0][0] = poured
        for i in range(0, 101):
            for j in range(0, i + 1):
                if ((result[i][j] - 1.0) / 2.0) > 0:
                    result[i+1][j] += (result[i][j] - 1) / 2.0
                    result[i+1][j+1] += (result[i][j] - 1) / 2.0
        return min(1, result[query_row][query_glass])
