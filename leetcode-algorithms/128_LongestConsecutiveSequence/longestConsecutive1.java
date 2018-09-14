class Solution {
    public int longestConsecutive(int[] nums) {
        // O(n) solution
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 1;

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                // this is the beginning
                int count = 1;
                int current = num;

                while (set.contains(current + 1)) {
                    count += 1;
                    current = current + 1;
                }

                max = Math.max(count, max);
            }
        }

        return max;
    }
}
