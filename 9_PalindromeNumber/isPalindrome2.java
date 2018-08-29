class Solution {
    public boolean isPalindrome(int x) {
        // 1. negative number is not palindrome
        // 2. nonzero number with last digit being 0 is not palidrome
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }

        int revertedNumber = 0;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
