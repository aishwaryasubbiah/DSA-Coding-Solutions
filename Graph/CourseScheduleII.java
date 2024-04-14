/* https://leetcode.com/problems/course-schedule-ii/ */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       int[] indegree = new int[numCourses];
       Arrays.fill(indegree, 0);
       for(int i=0; i<prerequisites.length; i++) {
           indegree[prerequisites[i][0]] += 1;
       }   
       Queue<Integer> queue = new LinkedList<>();
       for(int i=0; i<numCourses; i++) {
           if(indegree[i] == 0) queue.add(i);
       } 
       int[] order = new int[numCourses]; 
       int k = 0;
       while(!queue.isEmpty()) {
          int currTask = queue.remove();
          order[k++] = currTask;
          for(int i=0; i<prerequisites.length; i++) {
              if(prerequisites[i][1] == currTask){
                indegree[prerequisites[i][0]] -= 1;
                if(indegree[prerequisites[i][0]] == 0) queue.add(prerequisites[i][0]);
              }
          }
       }
       
       for(int i=0; i<numCourses; i++) {
           if(indegree[i] != 0) return (new int[0]);
       } 
       return order;
    }
    
}

/* Notes - Use topological Sort */