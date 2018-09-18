class Solution {
    public boolean isHappy(int n) {
        int current = n;
        int totalNumberOfOperations = 0;

        while (totalNumberOfOperations != 810) {
            int result = 0;

            while (current > 0) {
                int digit = current % 10;
                
                result += digit * digit;
                current = current / 10;
            }

            if (result == 1) {
                return true;
            }

            current = result;
            totalNumberOfOperations++;
        }

        return false;
    }
}
