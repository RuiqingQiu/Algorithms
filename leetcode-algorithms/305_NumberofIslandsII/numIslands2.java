class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] graph = new int[m][n];
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        int currentId = 1;

        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];

            graph[x][y] = currentId;
            dfs(set, graph, x - 1, y, m, n, currentId);
            dfs(set, graph, x + 1, y, m, n, currentId);
            dfs(set, graph, x, y + 1, m, n, currentId);
            dfs(set, graph, x, y - 1, m, n, currentId);

            set.add(currentId);

            result.add(set.size());
            currentId = currentId + 1;
        }

        return result;
    }

    private void dfs(HashSet<Integer> set, int[][] graph, int x, int y, int m, int n, int currentId) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }

        // Merge Island
        if (graph[x][y] != 0 && graph[x][y] != currentId) {
            if (set.contains(graph[x][y])) {
                set.remove(graph[x][y]);
            }

            graph[x][y] = currentId;

            dfs(set, graph, x - 1, y, m, n, currentId);
            dfs(set, graph, x + 1, y, m, n, currentId);
            dfs(set, graph, x, y + 1, m, n, currentId);
            dfs(set, graph, x, y - 1, m, n, currentId);
        }
    }
}
