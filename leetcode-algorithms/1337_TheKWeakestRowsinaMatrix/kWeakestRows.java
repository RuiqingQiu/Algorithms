class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Pair<Integer, Integer>> lst = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            lst.add(new Pair<>(sum, i));
        }
        Collections.sort(lst, (p1, p2) -> p1.getKey().compareTo(p2.getKey()));

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = lst.get(i).getValue();
        }

        return result;
    }
}
