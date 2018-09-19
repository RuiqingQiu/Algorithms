class Solution {
    public int calculate(String s) {
        String str = s.replaceAll(" ","");
        Stack<Integer> stack = new Stack<Integer>();
        char op = '+';

        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i))) {
                int number = 0;

                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    number = number * 10 + str.charAt(i) - '0';
                    i++;
                }
                switch (op) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }

                if (i < str.length()) {
                    op = str.charAt(i);
                }
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
