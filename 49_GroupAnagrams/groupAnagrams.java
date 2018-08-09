class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        int [][] characterCounts = new int[n][26];
        boolean [] visited = new boolean[n];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            for (int j = 0; j < str.length(); j++) {
                characterCounts[i][str.charAt(j) - 'a'] += 1;
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();

        int total = n;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<String> current = new ArrayList<String>();
                current.add(strs[i]);

                for (int j = i + 1; j < n; j++) {
                    if (characterCountsEquals(characterCounts[i], characterCounts[j])) {
                        visited[i] = true;
                        visited[j] = true;

                        current.add(strs[j]);
                    }
                }

                result.add(current);
            }
        }

        return result;
    }

    private boolean characterCountsEquals (int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }

        return true;
    }
}
