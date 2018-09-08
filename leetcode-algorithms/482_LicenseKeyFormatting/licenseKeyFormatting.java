class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String result = "";

        String tmp = S.replace("-", "");
        tmp = tmp.toUpperCase();
        int index = tmp.length();

        while (index >= 0) {
            if (index - K > 0) {
                result = "-" + tmp.substring(index - K, index) + result;
            } else {
                result = tmp.substring(0, index) + result;

            }

            index = index - K;
        }

        return result;
    }
}
