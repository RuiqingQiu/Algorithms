from collections import defaultdict

class Solution:
    def numBusesToDestination(self, routes, S, T):
        """
        :type routes: List[List[int]]
        :type S: int
        :type T: int
        :rtype: int
        """
        routeToBus = defaultdict(list)

        for i, route in enumerate(routes):
            for stop in route:
                routeToBus[stop].append(i)

        bfs_queue = [(S, 0)]
        stop_visited = set([S])

        for stop, bus in bfs_queue:
            if stop == T:
                return bus

            for change_bus in routeToBus[stop]:
                for reachable_stop in routes[change_bus]:
                    if reachable_stop not in stop_visited:
                        bfs_queue.append((reachable_stop, bus + 1))
                        stop_visited.add(reachable_stop)
                    routes[change_bus] = []
        return -1
