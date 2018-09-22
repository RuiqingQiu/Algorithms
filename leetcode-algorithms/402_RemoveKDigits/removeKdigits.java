class Solution {
    public String removeKdigits(String num, int k) {
        int length = num.length() - k;
        char[] tmp = new char[num.length()];
        int j = 0;

        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            while (j > 0 && current < tmp[j - 1] && k > 0) {
                j--;
                k--;
            }

            tmp[j++] = current;
        }

        int idx = 0;

        while (idx < length && tmp[idx] == '0')
            idx++;

        return idx == length ? "0": new String(tmp, idx, length - idx);
    }
}
