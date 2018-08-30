class Solution {
    public boolean isPalindrome(int x) {
        String convert = Integer.toString(x);

        return isPalidrome(convert);
    }

    public boolean isPalidrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
