class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int result = nums[0];
        int count = 0;

        for (int i : map.keySet()) {
            if (map.get(i) > count) {
                count = map.get(i);
                result = i;
            }
        }

        return result;
    }
}
