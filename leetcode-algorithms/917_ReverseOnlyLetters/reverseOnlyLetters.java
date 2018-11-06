class Solution {
    public String reverseOnlyLetters(String S) {
        char[] tmp = S.toCharArray();

        int index = S.length() - 1;
        int i = 0;
        while (index >= 0) {
            if (Character.isLetter(S.charAt(index))) {
                while (!Character.isLetter(tmp[i])) {
                    i++;
                }

                tmp[i++] = S.charAt(index);
            }
            index--;
        }

        return new String(tmp);
    }
}
