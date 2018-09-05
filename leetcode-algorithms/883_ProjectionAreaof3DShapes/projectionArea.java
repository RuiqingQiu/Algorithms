class Solution {
    public int projectionArea(int[][] grid) {
        int result = 0;

        // Bottom
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result += grid[i][j] != 0 ? 1 : 0;
            }
        }

        // front and back area is equal to the maximum of each column
        for (int j = 0; j < grid[0].length; j++) {
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }

            result += max;
        }

        // Left and Right
        for (int i = 0; i < grid.length; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }

            result += max;
        }

        return result;
    }
}
