class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (current == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (Character.isDigit(current)) {
                number = number * 10 + (int)(current - '0');
            } else if (current == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (current == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
