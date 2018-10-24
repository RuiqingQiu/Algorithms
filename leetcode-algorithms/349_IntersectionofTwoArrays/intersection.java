class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> lst = new ArrayList<Integer>();

        for (int num : nums2) {
            if (set.contains(num)) {
                lst.add(num);
                set.remove(num);
            }
        }

        int[] result = new int[lst.size()];

        for (int i = 0; i < lst.size(); i++) {
            result[i] = lst.get(i);
        }

        return result;
    }
}
