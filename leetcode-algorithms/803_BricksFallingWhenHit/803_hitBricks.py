class Solution:
    def hitBricks(self, grid, hits):
        """
        :type grid: List[List[int]]
        :type hits: List[List[int]]
        :rtype: List[int]
        """
        m, n = len(grid), len(grid[0])

        def dfs(i, j):
            if not (0 <= i < m and 0 <= j < n) or grid[i][j] != 1:
                return 0
            ret = 1
            grid[i][j] = 2
            ret += sum(dfs(x, y) for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)])
            return ret

        def is_connected(i, j):
            return i == 0 or any(0 <= x < m and 0 <= y < n and grid[x][y] == 2 for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)])

        for i, j in hits:
            grid[i][j] -= 1

        for i in range(n):
            dfs(0, i)

        ret = [0] * len(hits)
        for k in reversed(range(len(hits))):
            i, j = hits[k]
            grid[i][j] += 1
            if grid[i][j] == 1 and is_connected(i, j):
                ret[k] = dfs(i, j) - 1
        return ret
