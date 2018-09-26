class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();

            if (!minStack.isEmpty()) {
                min = minStack.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
