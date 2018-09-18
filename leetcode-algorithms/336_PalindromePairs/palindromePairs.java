class Solution {
    // Naive O(n^2k) solution
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalidrome(words[i] + words[j])) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
                if (isPalidrome(words[j] + words[i])) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(j);
                    tmp.add(i);
                    result.add(tmp);
                }
            }
        }

        return result;
    }

    public boolean isPalidrome(String current) {
        for (int i = 0; i < current.length() / 2; i++) {
            if (current.charAt(i) != current.charAt(current.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
