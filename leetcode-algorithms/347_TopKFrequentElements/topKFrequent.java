class Solution {
    class Pair {
        int val;
        int count;

        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.count - a.count;
            }
        });

        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 0);
            }
            countMap.put(num, countMap.get(num) + 1);
        }

        for (Integer key : countMap.keySet()) {
            pq.offer(new Pair(key, countMap.get(key)));
        }

        while (!pq.isEmpty() && result.size() != k) {
            result.add(pq.poll().val);
        }

        return result;
    }
}
