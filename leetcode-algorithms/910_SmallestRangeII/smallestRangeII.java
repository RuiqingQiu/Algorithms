class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        int result = max - min;

        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(A[i] + K, A[A.length - 1] - K);
            min = Math.min(A[i + 1] - K, A[0] + K);

            result = Math.min(result, max - min);
        }

        return result;

    }
}
