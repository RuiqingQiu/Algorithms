class Solution {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double j = Math.sqrt(c - i * i);

            if (j == (int)j) {
                return true;
            }
        }

        return false;
    }
}
