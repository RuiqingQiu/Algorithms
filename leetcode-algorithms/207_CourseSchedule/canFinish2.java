public class Solution {
    //dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        boolean[] visited = new boolean[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, graph, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(boolean[] visited, ArrayList[] graph, int current) {
        if (visited[current]) {
            return false;
        }
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            if (!dfs(visited, graph, (int)graph[current].get(i))) {
                return false;
            }
        }
        visited[current] = false;

        return true;
    }
}
