class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int count = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                int start = i - count;

                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(start));
                    start++;
                    count--;
                }
            }
            set.add(s.charAt(i));
            count++;
            max = Math.max(max, count);
        }

        return max;
    }
}
