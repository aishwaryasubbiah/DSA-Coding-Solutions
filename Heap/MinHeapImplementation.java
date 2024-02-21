/* https://www.codingninjas.com/studio/problems/min-heap_4691801?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM */

import java.util.* ;
import java.io.*; 

public class Solution {
    static int[] minHeap(int n, int[][] q) {
        int k =0, count=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            if(q[i][0] == 1) count++;
        }
        int[] out = new int[count];
        for(int i=0; i<n; i++) {
            if(q[i][0] == 0) pq.add(q[i][1]);
            else if(q[i][0] == 1) out[k++] = pq.remove();
        }
        return out;
    }
}