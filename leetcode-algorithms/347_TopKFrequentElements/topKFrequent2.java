class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : map.keySet()) {
            if (bucket[map.get(num)] == null) {
                bucket[map.get(num)] = new LinkedList<>();
            }

            bucket[map.get(num)].add(num);
        }

        for (int i = nums.length; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        return result;
    }
}
