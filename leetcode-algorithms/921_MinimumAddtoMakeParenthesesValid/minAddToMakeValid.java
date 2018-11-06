class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character>();

        int result = 0;
        
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);

            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                if (stack.isEmpty()) {
                    result += 1;
                } else {
                    stack.pop();
                }
            }
        }

        result += stack.size();

        return result;
    }
}
