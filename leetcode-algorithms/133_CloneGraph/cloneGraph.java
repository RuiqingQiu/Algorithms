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
        if (node == null) {
            return null;
        }
        
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

        map.put(result.label, result);

        dfs(node, result, map);

        return result;
    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode newNode, HashMap<Integer, UndirectedGraphNode> map) {
        for (int i = 0; i < node.neighbors.size(); i++) {

            if (map.containsKey(node.neighbors.get(i).label)) {
                newNode.neighbors.add(map.get(node.neighbors.get(i).label));
            } else {
                UndirectedGraphNode copy = new UndirectedGraphNode(node.neighbors.get(i).label);

                map.put(copy.label, copy);
                newNode.neighbors.add(copy);
                dfs(node.neighbors.get(i), copy, map);
            }
        }
    }
}
