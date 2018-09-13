class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int x = 0; // start index for row
        int y = 0; // start index for col
        int m = matrix.length; // end index for row;
        int n = matrix[0].length; // end index for col;

        while (x < m && y < n) {
            for (int i = y; i < n; i++) {
                result.add(matrix[x][i]);
            }
            x++;

            for (int i = x; i < m; i++) {
                result.add(matrix[i][n - 1]);
            }
            n--;

            if (x < m) {
                for (int i = n - 1; i >= y; i--) {
                    result.add(matrix[m - 1][i]);
                }
                m--;
            }

            if (y < n) {
                for (int i = m - 1; i >= x; i--) {
                    result.add(matrix[i][y]);
                }
                y++;
            }
        }

        return result;
    }
}
