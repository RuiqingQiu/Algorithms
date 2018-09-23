class MyHashSet {

    int bucket = 1000;
    int itemsPerBucket = 1001;

    private boolean[][] table;
    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[bucket][];
    }

    private int hash(int key) {
        return key % bucket;
    }

    private int getPosition(int key) {
        return key / bucket;
    }

    public void add(int key) {
        int hash = hash(key);

        if (table[hash] == null) {
            table[hash] = new boolean[itemsPerBucket];
        }

        table[hash][getPosition(key)] = true;
    }

    public void remove(int key) {
        int hash = hash(key);

        if (table[hash] != null) {
            table[hash][getPosition(key)] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);

        return table[hash] != null && table[hash][getPosition(key)];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
