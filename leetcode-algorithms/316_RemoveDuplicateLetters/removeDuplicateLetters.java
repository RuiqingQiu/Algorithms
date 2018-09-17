class Solution {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        String result = "0";

        for (char c : s.toCharArray()) {
            map[c - 'a']--;

            if (visited[c - 'a']) {
                continue;
            }

            Character last = result.charAt(result.length() - 1);

            while (c < last && map[last - 'a'] > 0) {
                visited[last - 'a'] = false;
                result = result.substring(0, result.length() - 1);
                last = result.charAt(result.length() - 1);
            }

            result += c;
            visited[c - 'a'] = true;
        }

        return result.substring(1);
    }
}
