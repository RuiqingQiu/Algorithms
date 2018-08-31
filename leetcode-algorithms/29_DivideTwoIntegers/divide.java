class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int result = 0;

        while (a - b >= 0) {
            int i = 0;
            for (i = 0; a - (b << i << 1) >= 0; i++) {
            }
            result += 1 << i;
            a -= b << i;
        }

        return (dividend > 0) == (divisor > 0) ? result : -result;
    }
}
