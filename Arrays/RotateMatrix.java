/* https://leetcode.com/problems/rotate-image/description/ */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l;
        for(int row = 0; row < n; row++) {
           for(int col = row+1; col < n; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
           } 
        }
        for(int row = 0; row < n; row++) {
            l = n-1;
           for(int col = 0; col < n/2; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][l];
                matrix[row][l] = temp;
                l--;
           } 
        }
    }
}