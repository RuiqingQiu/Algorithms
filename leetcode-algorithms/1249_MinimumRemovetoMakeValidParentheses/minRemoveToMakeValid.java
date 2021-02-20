class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else if (s.charAt(i) == ')') {
                // remove ')'.
                if (count == 0) {
                    continue;
                }
                count -= 1;
            }
            sb.append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && count-- > 0) {
                continue;
            }
            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }
} 
