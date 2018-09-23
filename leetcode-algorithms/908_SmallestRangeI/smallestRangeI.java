class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        if (max - min < 2 * K) {
            return 0;
        } else {
            return (max - min) - 2 * K;
        }
    }
}
