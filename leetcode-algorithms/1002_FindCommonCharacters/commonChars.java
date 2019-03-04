class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<String>();

        if (A == null || A.length == 0) {
            return result;
        }

        int[] count = new int[26];

        for (char c : A[0].toCharArray()) {
            count[c - 'a'] += 1;
        }

        for (int i = 1; i < A.length; i++) {
            int[] tmp = new int[26];
            for (char c : A[i].toCharArray()) {
                tmp[c - 'a'] += 1;
            }

            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], tmp[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add(Character.toString((char)('a' + i)));
            }
        }

        return result;
    }
}
