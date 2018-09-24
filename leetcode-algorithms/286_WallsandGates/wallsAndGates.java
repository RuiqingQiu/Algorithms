class Solution {
    final int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length;
        int n = rooms[0].length;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / n;
            int y = current % n;

            if (x - 1 >= 0 && rooms[x - 1][y] == INF) {
                rooms[x - 1][y] = rooms[x][y] + 1;
                queue.add((x - 1) * n + y);
            }

            if (x + 1 < m && rooms[x + 1][y] == INF) {
                rooms[x + 1][y] = rooms[x][y] + 1;
                queue.add((x + 1) * n + y);
            }

            if (y - 1 >= 0 && rooms[x][y - 1] == INF) {
                rooms[x][y - 1] = rooms[x][y] + 1;
                queue.add(x * n + y - 1);
            }

            if (y + 1 < n && rooms[x][y + 1] == INF) {
                rooms[x][y + 1] = rooms[x][y] + 1;
                queue.add(x * n + y + 1);
            }
        }
    }
}
