class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            long mid = (start + end) >>> 1;

            if (num == mid * mid) {
                return true;
            } else if (num > mid * mid) {
                start = (int)mid + 1;
            } else {
                end = (int)mid - 1;
            }
        }

        return false;
    }
}
