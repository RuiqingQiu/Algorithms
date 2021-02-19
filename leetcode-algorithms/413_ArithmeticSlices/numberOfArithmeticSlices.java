class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int current = 0;
        int result = 0;

        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                current += 1;
                result += current;
            } else {
                current = 0;
            }
        }

        return result;
    }
}
