class Solution {
    public String convertToTitle(int n) {
        String result = "";

        while (n > 0) {
            n--;
            int current = n % 26;

            result = (char)('A' + current) + result;

            n = n / 26;
        }

        return result;
    }
}
