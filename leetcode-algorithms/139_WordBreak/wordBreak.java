class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isWord = new boolean[s.length() + 1];
        isWord[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isWord[j] && wordDict.contains(s.substring(j, i))) {
                    isWord[i] = true;
                }
            }
        }

        return isWord[s.length()];
    }
}
