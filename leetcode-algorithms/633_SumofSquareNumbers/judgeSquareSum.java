class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Long> set = new HashSet<>();

        for (long i = 0; i * i <= c; i++) {
            long result = i * i;
            set.add(result);

            if (set.contains(c - result)) {
                return true;
            }
        }

        return false;
    }
}
