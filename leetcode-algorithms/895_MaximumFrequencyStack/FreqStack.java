class FreqStack {

    Map<Integer, Stack<Integer>> mapOfCountAndStack = new HashMap<>();
    Map<Integer, Integer> mapOfNumAndCount = new HashMap<>();
    int max = 0;
    public FreqStack.() {

    }

    public void push(int x) {
        int count = mapOfNumAndCount.getOrDefault(x, 0) + 1;
        mapOfNumAndCount.put(x, count);
        max = Math.max(max, count);

        if (!mapOfCountAndStack.containsKey(count)) {
            mapOfCountAndStack.put(count, new Stack<Integer>());
        }

        mapOfCountAndStack.get(count).add(x);
    }

    public int pop() {
        int result = mapOfCountAndStack.get(max).pop();
        mapOfNumAndCount.put(result, max - 1);
        if (mapOfCountAndStack.get(max).size() == 0) {
            max--;
        }

        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
