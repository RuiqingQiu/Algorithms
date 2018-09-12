/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    private int max = 1;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (NestedInteger current : nestedList) {
            helper(current, 1, map);
        }

        int result = 0;

        for (int key : map.keySet()) {
            int level = max - key + 1;

            for (int value : map.get(key)) {
                result += level * value;
            }
        }

        return result;
    }

    private void helper(NestedInteger current, int level, HashMap<Integer, List<Integer>> map) {
        max = Math.max(max, level);

        if (current.isInteger()) {
            if (!map.containsKey(level)) {
                map.put(level, new ArrayList<Integer>());
            }

            map.get(level).add(current.getInteger());
        } else {
            for (NestedInteger tmp : current.getList()) {
                helper(tmp, level + 1, map);
            }
        }
    }
}
