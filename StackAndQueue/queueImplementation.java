/* https://www.codingninjas.com/studio/problems/implement-queue-using-arrays_8390825?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM */

public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        public void enqueue(int e) {
            if(rear < arr.length) arr[rear++] = e;
        }

        public int dequeue() {
            // Write your code here.
            if(front < arr.length && front < rear) {
                return arr[front++];
            }
            return -1;
        }
    }
}