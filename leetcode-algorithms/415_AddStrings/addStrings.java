class Solution {
    public String addStrings(String num1, String num2) {        
        int max = Math.max(num1.length(), num2.length());
        char[] result = new char[max];

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = max - 1;

        int remain = 0;

        while (i >= 0 || j >= 0) {
            int first = 0;
            int second = 0;

            if (i >= 0) {
                first = (num1.charAt(i--) - '0');
            }

            if (j >= 0) {
                second = (num2.charAt(j--) - '0');
            }

            result[k--] = (char)((first + second + remain) % 10 + '0');

            remain = (first + second + remain) / 10;
        }

        if (remain != 0) {
            return '1' + String.valueOf(result);
        }

        return String.valueOf(result);


    }
}
