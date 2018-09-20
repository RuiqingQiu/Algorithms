/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);

        for (int i = 0; i < node.neighbors.size(); i++) {
            copy.neighbors.add(clone(node.neighbors.get(i), map));
        }

        return copy;
    }
}
