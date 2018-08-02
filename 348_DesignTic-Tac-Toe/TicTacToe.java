class TicTacToe {
    int size;
    int [] rows;
    int [] cols;
    int diagonal;
    int otherDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.size = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        otherDiagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int value = player == 1 ? 1 : -1;

        rows[row] += value;
        cols[col] += value;

        if (row == col) {
            diagonal += value;
        }

        if (row == size - col - 1) {
            otherDiagonal += value;
        }

        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size ||
            Math.abs(otherDiagonal) == size) {
            return player;
        }

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
