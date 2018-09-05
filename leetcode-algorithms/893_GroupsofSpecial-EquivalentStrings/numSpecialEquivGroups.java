class Solution {
    public int numSpecialEquivGroups(String[] A) {

        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int j = 0; j < A.length; j++) {
            String str = A[j];
            char [] tmp = str.toCharArray();
            char [] p1;
            char [] p2;
            if (str.length() % 2 == 0) {
                p1 = new char[str.length()];
                p2 = new char[str.length()];

                for (int i = 0; i < tmp.length; i++) {
                    if (i %  2 == 0)
                        p1[i] = tmp[i];
                    else
                        p2[i] = tmp[i];
                }
            } else {
                p1 = new char[str.length() + 1];
                p2 = new char[str.length()];

                for (int i = 0; i < tmp.length; i++) {
                    if (i %  2 == 0)
                        p1[i] = tmp[i];
                    else
                        p2[i] = tmp[i];
                }
            }

            Arrays.sort(p1);
            Arrays.sort(p2);
            String key = new String(p1) + new String(p2);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            map.get(key).add(j);
        }

        return map.keySet().size();
    }
}
