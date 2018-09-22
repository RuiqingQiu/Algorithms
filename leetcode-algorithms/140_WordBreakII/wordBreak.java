class Solution {
    // Recursion brute force with memoization
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    public List<String> helper(String s, List<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> result = new ArrayList<String>();

        if (start == s.length()) {
            result.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = helper(s, wordDict, end);

                for (String str : list) {
                    result.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
                }
            }
        }

        map.put(start, result);

        return result;
    }
}
