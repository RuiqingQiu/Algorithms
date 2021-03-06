class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = board[i][j];
                int sum = neighborsSum(board, i, j, m, n);

                if (current == 1) {
                    if (sum < 2) {
                        board[i][j] = -1;
                    } else if (sum == 2 || sum == 3) {
                        // live
                    } else {
                        board[i][j] = -1;
                    }
                } else {
                    if (sum == 3) {
                        board[i][j] = -2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int neighborsSum(int[][] board, int i, int j, int m, int n) {
        int sum = 0;

        int widthStart = Math.max(i - 1, 0);
        int widthEnd = Math.min(i + 1, m - 1);

        int heightStart = Math.max(j - 1, 0);
        int heightEnd = Math.min(j + 1, n - 1);

        for (int x = widthStart; x <= widthEnd; x++) {
            for (int y = heightStart; y <= heightEnd; y++) {
                if (x == i && y == j) {
                    continue;
                } else {
                    if (board[x][y] == -1) {
                        sum += 1;
                    } else if (board[x][y] == -2) {
                        sum += 0;
                    } else {
                        sum += board[x][y];
                    }
                }
            }
        }

        return sum;
    }
}
