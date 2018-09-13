class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length - 1;

        if (bits[n] == 1) {
            return false;
        } else {
            if (n - 1 < 0 || bits[n - 1] == 0) {
                return true;
            }

            boolean result = true;
            n--;
            while (n >= 0 && bits[n] == 1) {
                result = !result;
                n--;
            }
            return result;
        }
    }
}
