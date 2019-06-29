class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;

                switch(c) {
                    case ')':
                        if (stack.peek() != '(')
                            return false;
                        break;
                    case '}':
                        if (stack.peek() != '{')
                            return false;
                        break;
                    case ']':
                        if (stack.peek() != '[')
                            return false;
                        break;
                }
                stack.pop();
            }
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
