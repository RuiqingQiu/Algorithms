class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<String>();

        for (String s : A) {
            int [] odd = new int[26];
            int [] even = new int[26];

            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    even[s.charAt(i) - 'a'] += 1;
                } else {
                    odd[s.charAt(i) - 'a'] += 1;
                }
            }

            String key = Arrays.toString(odd) + Arrays.toString(even);

            set.add(key);
        }

        return set.size();
    }
}
