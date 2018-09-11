class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }

        return fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double result = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}
