class Solution:
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        # m = len(matrix)
        # n = len(matrix[0])
        #
        # for i in range(m):
        #     for j in range(n):
        #         current = matrix[i][j]
        #         index = 1
        #         while i + index < m and j + index < n:
        #             if current != matrix[i + index][j + index]:
        #                 return False
        #             index += 1
        #
        # return True
        return all(r == 0 or c == 0 or matrix[r-1][c-1] == val
                    for r, row in enumerate(matrix)
                    for c, val in enumerate(row))
        #
        # for r, row in enumerate(matrix):
        #     for c, val in enumerate(row):
        #         r == 0 or c == 0 or matrix[r-1][c-1] == val
