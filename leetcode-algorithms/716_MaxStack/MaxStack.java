class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> maxStack;
    Stack<Integer> stack;

    public MaxStack() {
        maxStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();

        maxStack.push(max > x ? max : x);

        stack.push(x);
    }

    public int pop() {
        maxStack.pop();

        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();

        Stack<Integer> buffer = new Stack<Integer>();

        while (top() != max) {
            buffer.push(pop());
        }

        pop();

        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }

        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */