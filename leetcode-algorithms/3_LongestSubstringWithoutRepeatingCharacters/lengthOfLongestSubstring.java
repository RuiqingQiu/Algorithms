class Solution{
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                count++;
            } else {
                if (count > max) {
                    max = count;   
                }
                int j = i - count;
                while (j < i && s.charAt(j) != s.charAt(i)) {
                    set.remove(s.charAt(j));
                    count--;
                    j++;
                }
            }
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
}
