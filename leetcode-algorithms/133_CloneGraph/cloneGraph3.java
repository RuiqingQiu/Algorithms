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

        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode current, HashMap<Integer, UndirectedGraphNode> map) {
        if (current == null) {
            return null;
        }

        UndirectedGraphNode copy;

        if (map.containsKey(current.label)) {
            return map.get(current.label);
        } else {
            copy = new UndirectedGraphNode(current.label);
        }

        map.put(copy.label, copy);

        for (UndirectedGraphNode neighbor : current.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }

        return copy;
    }
}
