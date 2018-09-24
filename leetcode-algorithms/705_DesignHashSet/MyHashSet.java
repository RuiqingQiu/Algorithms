class MyHashSet {

    int bucket = 1000;
    int itemsPerBucket = 1001;
    boolean[][] table;

    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new boolean[bucket][];
    }

    public void add(int key) {
        int hash = key % bucket;

        if (table[hash] == null) {
            table[hash] = new boolean[bucket];
        }

        table[hash][key / bucket] = true;
    }
    
    public void remove(int key) {
        int hash = key % bucket;

        if (table[hash] != null) {
            table[hash][key / bucket] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % bucket;

        return table[hash] != null && table[hash][key / bucket];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
