class Solution:
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        total = 0
        m = len(grid)
        n = len(grid[0])

        for row in range(m):
            for column in range(n):
                if grid[row][column] == 1:
                    if row - 1 < 0:
                        total += 1
                    elif grid[row - 1][column] == 0:
                        total += 1
                    if column - 1 < 0:
                        total += 1
                    elif grid[row][column - 1] == 0:
                        total += 1
                    if row + 1 >= m:
                        total += 1
                    elif grid[row+1][column] == 0:
                        total += 1
                    if column + 1 >= n:
                        total += 1
                    elif grid[row][column + 1] == 0:
                        total += 1
        return total
