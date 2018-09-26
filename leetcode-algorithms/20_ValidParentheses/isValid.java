class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            switch (current) {
                case '(' :
                    stack.push('(');
                    break;

                case ')' :
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '[' :
                    stack.push('[');
                    break;

                case ']' :
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }

                    break;

                case '{' :
                    stack.push('{');
                    break;

                case '}' :
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }

        return stack.size() == 0;
    }
}
