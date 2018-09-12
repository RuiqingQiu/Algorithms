class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;

                if (index2 != -1) {
                    result = Math.min(result, Math.abs(index2 - index1));

                }
            } else if (words[i].equals(word2)) {
                index2 = i;

                if (index1 != -1) {
                    result = Math.min(result, Math.abs(index2 - index1));
                }
            }
        }


        return result;
    }
}
