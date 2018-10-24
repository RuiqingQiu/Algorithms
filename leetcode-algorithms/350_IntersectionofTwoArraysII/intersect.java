class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }

            map.put(num, map.get(num) + 1);
        }

        List<Integer> lst = new ArrayList<Integer>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                lst.add(num);

                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
        }

        int[] result = new int[lst.size()];

        for (int i = 0; i < lst.size(); i++) {
            result[i] = lst.get(i);
        }

        return result;
    }
}
