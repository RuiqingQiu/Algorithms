class Solution:
    def maxIncreaseKeepingSkyline(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        skyline_top_bottom = []
        skyline_left_right = []


        for row in range(len(grid)):
            skyline_left_right.append(max(grid[row]))
        
        for column in range(len(grid[0])):
            max_val = 0
            for row in range(len(grid)):
                if max_val < grid[row][column]:
                    max_val = grid[row][column]
            skyline_top_bottom.append(max_val)

        result = 0
        for row in range(len(grid)):
            for column in range(len(grid[0])):
                result += min(skyline_left_right[row], skyline_top_bottom[column]) - grid[row][column]

        return result
