class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<Integer>();
        String[] splited = input.split("\n");
        int result = 0;

        stack.push(0);

        for (String current : splited) {
            int level = current.lastIndexOf("\t") + 1;

            while (level + 1 < stack.size()) {
                stack.pop();
            }

            // Remove "\t" add "/"
            int length = stack.peek() + current.length() - level + 1;

            if (current.contains(".")) {
                result = Math.max(result, length - 1);
            } else {
                stack.push(length);
            }
        }

        return result;

    }
}
