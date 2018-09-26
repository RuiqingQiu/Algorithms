class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Per Row
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    System.out.println(1);
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        // Per column
        for (int j = 0; j < board[0].length; j++) {
            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    System.out.println(2);

                    return false;
                }
                set.add(board[i][j]);
            }
        }

        // Per 3x3 square
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                HashSet<Character> set = new HashSet<>();

                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i + x][j + y] == '.') {
                            continue;
                        }

                        if (set.contains(board[i + x][j + y])) {
                            return false;
                        }

                        set.add(board[i + x][j + y]);
                    }
                }
            }
        }

        return true;
    }
}
