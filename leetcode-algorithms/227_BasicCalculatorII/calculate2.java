class Solution {
    public int calculate(String s) {
        String str = s.replaceAll(" ", "");
        int result = 0;
        int currentResult = 0;
        char op = '+';

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int number = str.charAt(i) - '0';
                i++;

                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    number = number * 10 + str.charAt(i) - '0';
                    i++;
                }

                switch (op) {
                    case '+' : currentResult += number; break;
                    case '-' : currentResult -= number; break;
                    case '*' : currentResult *= number; break;
                    case '/' : currentResult /= number; break;
                }

                i--;
            } else {
                if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                    result += currentResult;
                    currentResult = 0;
                }
                op = str.charAt(i);
            }
        }

        return result + currentResult;
    }
}
