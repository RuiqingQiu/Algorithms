class Solution:
    def eventualSafeNodes(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[int]
        """
        # compute the out degree of each node
        n = len(graph)
        out_degree = collections.defaultdict(int)
        in_node = collectios.defaultdict(list)
        result = []

        queue = []
        for i in range(0, len(graph)):
            out_degree[i] = len(graph[i])

            while out_degree[i] == 0:
                queue.append(i)

            for j in graph[i]:
                in_node[j].append(i)

        while queue:
            current_node = queue.pop(0)
            result.append(current_node)

            for node in in_node[current_node]:
                out_degree[node] -= 1
                if (out_degree[node] == 0):
                    queue.append(node)
        return sorted(result)
