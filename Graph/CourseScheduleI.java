/* https://leetcode.com/problems/course-schedule/ */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        for(int i=0; i< prerequisites.length; i++){
            indegree[prerequisites[i][0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< numCourses; i++){
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int currtask = queue.remove();
            for(int i=0; i<prerequisites.length; i++) {
                if(prerequisites[i][1] == currtask) {
                    indegree[prerequisites[i][0]] -= 1;
                    if(indegree[prerequisites[i][0]] == 0) queue.add(prerequisites[i][0]);
                }
            }
        }
        for(int i=0; i< numCourses; i++){
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}

/* Notes - Use topological Sort */