class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));

        for (String tmp : d) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (count < tmp.length() && tmp.charAt(count) == s.charAt(i)) {
                    count++;
                }
            }
            if (count == tmp.length()) {
                return tmp;
            }
        }

        return "";
    }
}
