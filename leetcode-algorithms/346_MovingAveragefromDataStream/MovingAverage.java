class MovingAverage {

    Queue<Integer> queue;
    int size;
    int total;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        total = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            total -= queue.poll();
        }

        total += val;
        queue.offer(val);

        return (double)total / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
