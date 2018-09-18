class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // for case where there's not a valid sentence, need to have a way to early terminate it
        // One example is follow:
        // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
        // ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]

        // Check if there is at least one possible solution
        boolean[] isSentence = new boolean[s.length() + 1];

        isSentence[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isSentence[j] && wordDict.contains(s.substring(j, i))) {
                    isSentence[i] = true;
                    break;
                }
            }
        }

        // We are done if there isn't a valid sentence at all
        if (!isSentence[s.length()]) {
            return new ArrayList<String>();
        }

        List<String>[] dp = new List[s.length() + 1];
        List<String> start = new ArrayList<String>();
        start.add("");
        dp[0] = start;

        for (int i = 1; i <= s.length(); i++) {
            List<String> list = new ArrayList<String>();

            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String str : dp[j]) {
                        list.add(str + (str.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }

        return dp[s.length()];
    }
}
