class Solution {
    public int scoreOfParentheses(String S) {
        return helper(S, 0, S.length());
    }

    private int helper(String S, int start, int end) {
        int result = 0;
        int balance = 0;
        for (int i = start; i < end; i++) {
            if (S.charAt(i) == '(') {
                balance += 1;
            } else {
                balance -= 1;
            }

            if (balance == 0) {
                if (i - start == 1) {
                    result += 1;
                } else {
                    result += 2 * helper(S, start + 1, i);
                }
                start = i + 1;
            }
        }

        return result;
    }
}
