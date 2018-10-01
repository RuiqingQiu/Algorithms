class Solution {
//     public int largestPalindrome(int n) {
//         int num1 = 0;
//         int num2 = 0;
//         long max = -1;

//         for (int i = 0; i < n; i++) {
//             num1 = num1 * 10 + 9;
//         }

//         int min = (n - 1) * 10;

//         for (long i = num1; i >= min; i--) {
//             for (long j = num1; j >= min; j--) {
//                 if (i * j <= max) {
//                     break;
//                 }

//                 if (isPalindrome(i * j)) {
//                     max = Math.max(max, i * j);
//                     break;
//                 }
//             }
//         }

//         if (max == -1) {
//             return -1;
//         } else {
//             return (int)(max % 1337);
//         }
//     }

//     private boolean isPalindrome(long n) {
//         String str = Long.toString(n);

//         for (int i = 0; i < str.length() / 2; i++) {
//             if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
//                 return false;
//             }
//         }

//         return true;

//     }
    public int largestPalindrome(int n) {
        long max = (long)Math.pow(10, n) - 1;
        long min = max / 10;

        for (long h = max; h > min; h--) {
            long left = h, right = 0;

            for (long i = h; i != 0; right = right * 10 + i % 10, i /= 10, left *= 10);

            long palindrom = left + right;      // construct the palindrome

            for (long i = max; i > min; i--) {
                long j = palindrom / i;
                if (j > i) break;     // terminate if the other number is greater than current number
                if (palindrom % i == 0) return (int)(palindrom % 1337); // found if current number is a factor
            }
        }

        return 9;    // account for case n = 1
    }
}
