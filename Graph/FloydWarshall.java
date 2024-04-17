/* https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1 */


class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j< matrix[i].length; j++) {
                if(matrix[i][j] == -1)
                  matrix[i][j] = Integer.MAX_VALUE;
            }
        }         
        for(int via = 0; via < matrix.length; via++) {
            for(int i=0; i< matrix.length; i++) {
                for(int j=0; j< matrix[i].length; j++) {
                    if(matrix[i][via] != Integer.MAX_VALUE && matrix[via][j] != Integer.MAX_VALUE)
                      matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }             
        }
        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j< matrix[i].length; j++) {
                if(matrix[i][j] == Integer.MAX_VALUE)
                  matrix[i][j] = -1;
            }
        }  

    }
}