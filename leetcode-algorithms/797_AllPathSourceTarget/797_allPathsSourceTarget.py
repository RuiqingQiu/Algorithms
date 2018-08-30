from copy import deepcopy

class Solution:
    def allPathsSourceTarget(self, graph):
        def getAllPath(start, end, visited, path, result) :
            visited[start] = True
            path.append(start)

            if start == end:
                result.append(deepcopy(path))
            else:
                for i in graph[start]:
                    if visited[i] == False:
                        getAllPath(i, end, visited, path, result)

            path.pop()
            visited[start] = False
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        visited = [False] * len(graph)
        path = []
        result = []
        getAllPath(0, len(graph) - 1, visited, path, result)

        return result
