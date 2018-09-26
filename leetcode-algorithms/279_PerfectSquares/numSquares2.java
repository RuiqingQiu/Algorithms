class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        // contains all perfect square numbers which are smaller than or equal to n
        List<Integer> perfectSquares = new ArrayList<>();

        // countPerfectSquares[i - 1] = the least number of perfect square numbers
        // which sum to i
        int[] countPerfectSquares = new int[n];

        // get all perfect squares which are less than or equal to n
        for (int i = 1; i * i <= n; i++) {
            perfectSquares.add(i * i);
            countPerfectSquares[i * i - 1] = 1;
        }

        if (perfectSquares.get(perfectSquares.size() - 1) == n) {
            return 1;
        }

        // Consider a graph which consists of number 0, 1,...,n as
        // its nodes. Node j is connected to node i via an edge if
        // and only if either j = i + (a perfect square number) or
        // i = j + (a perfect square number). Starting from node 0,
        // do the breadth-first search. If we reach node n at step
        // m, then the least number of perfect square numbers which
        // sum to n is m. Here since we have already obtained the
        // perfect square numbers, we have actually finished the
        // search at step 1.
        Queue<Integer> queue = new LinkedList<>();

        for (int perfectSquare : perfectSquares) {
            queue.add(perfectSquare);
        }

        int count = 1;

        while (!queue.isEmpty()) {
            count += 1;

            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                int current = queue.poll();

                for (int perfectSquare : perfectSquares) {
                    if (current + perfectSquare == n) {
                        return count;
                    } else if (current + perfectSquare < n && countPerfectSquares[current + perfectSquare - 1] == 0) {
                        countPerfectSquares[current + perfectSquare - 1] = count;
                        queue.add(current + perfectSquare);
                    } else if (current + perfectSquare > n) {
                        break;
                    }
                }
            }
        }

        return 0;
    }
}
