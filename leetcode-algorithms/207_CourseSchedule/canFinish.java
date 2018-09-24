public class Solution {
  //bfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        int count = 0;

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == current) {
                    indegree[prerequisites[i][0]]--;

                    if (indegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }
}
