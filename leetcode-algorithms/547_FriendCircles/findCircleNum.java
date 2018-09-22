class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                count++;
            }

        }

        return count;
    }

    private void dfs(int[][] M, int i, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }

    private void dfs(int[][] M, int i, int j) {
        if (i < 0 || j < 0 || i >= M.length || j >= M[0].length) {
            return;
        }

        if (M[i][j] == 1) {
            M[i][j] = 0;
            dfs(M, i + 1, j);
            dfs(M, i - 1, j);
            dfs(M, i, j + 1);
            dfs(M, i, j - 1);
        } else {
            return;
        }
    }
}
