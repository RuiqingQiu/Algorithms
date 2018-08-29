class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String current = strs[i];
            int length = current.length();
            if (prefix.length() > length) {
                prefix = prefix.substring(0, length);
            }

            for (int j = 0; j < prefix.length(); j++) {
                if (current.charAt(j) != prefix.charAt(j)) {
                    prefix = prefix.substring(0, j);
                }
            }
        }

        return prefix;
    }
}
