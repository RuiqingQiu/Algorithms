class Solution {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() <= 1) {
            return 0;
        }
        
        int countEndWithZero = 0;
        int countEndWithOne = 0;

        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            countEndWithOne = Math.min(countEndWithZero, countEndWithOne) + (current == '0' ? 1 : 0);
            countEndWithZero += (current == '1' ? 1 : 0);
        }

        return Math.min(countEndWithOne, countEndWithZero);
    }
}
