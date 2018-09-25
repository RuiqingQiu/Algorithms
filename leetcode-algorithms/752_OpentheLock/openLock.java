class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();

        for (String deadend : deadends) {
            dead.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int depth = 0;

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current == null) {
                depth++;

                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (current.equals(target)) {
                return depth;
            } else if (!dead.contains(current)) {
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d += 2) {
                        int y = (current.charAt(i) - '0' + d + 10) % 10;

                        String newString = current.substring(0, i) + ("" + y) + current.substring(i + 1);

                        if (!seen.contains(newString)) {
                            queue.offer(newString);
                            seen.add(newString);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
