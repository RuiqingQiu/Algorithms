class Solution {
    public int addDigits(int num) {
        while (true) {
            int result = 0;

            while (num > 0) {
                int digit = num % 10;
                result += digit;
                num = num / 10;
            }

            if (result < 10) {
                return result;
            }

            num = result;
        }
    }
}
