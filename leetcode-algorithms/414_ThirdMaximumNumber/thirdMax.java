class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3);
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                continue;
            } else {
                if (pq.size() == 3) {
                    if (num > pq.peek()) {
                        int removed = pq.poll();
                        pq.offer(num);
                        set.remove(removed);
                        set.add(num);
                    }
                } else {
                    pq.offer(num);
                    set.add(num);
                }
            }
        }

        if (pq.size() == 3) {
            return pq.poll();
        } else {
            int result = 0;

            while (!pq.isEmpty()) {
                result = pq.poll();
            }

            return result;
        }

    }
}
