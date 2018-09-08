class Solution {
    public int binaryGap(int N) {
        int result = 0;

        for (int i = -32; N > 0; N /= 2, i++) {
            if (N % 2 == 1) {
                result = Math.max(result, i);
                i = 0;
            }
        }

        return result;
    }
}
