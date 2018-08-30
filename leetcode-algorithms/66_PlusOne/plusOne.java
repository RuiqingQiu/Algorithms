class Solution {
    // Original solution
    // public int[] plusOne(int[] digits) {
    //     int n = digits.length;
    //     int carry = 1;
    //
    //     for (int i = n - 1; i >= 0; i--) {
    //         int current = digits[i] + carry;
    //
    //         if (current >= 10) {
    //             carry = 1;
    //             current = current % 10;
    //             digits[i] = current;
    //         } else {
    //             carry = 0;
    //             digits[i] = current;
    //             break;
    //         }
    //
    //     }
    //
    //     if (carry == 1) {
    //         int [] result = new int[n + 1];
    //
    //         result[0] = 1;
    //
    //         for (int i = 0; i < n; i++) {
    //             result[i + 1] = digits[i];
    //         }
    //         return result;
    //     }
    //
    //     return digits;
    // }

    // Smart Solution
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[n + 1];

        result[0] = 1;

        for (int i = 0; i < n; i++) {
            result[i + 1] = digits[i];
        }

        return result;
    }
}
