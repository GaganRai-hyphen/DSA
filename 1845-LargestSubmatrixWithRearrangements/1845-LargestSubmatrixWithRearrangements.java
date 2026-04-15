// Last updated: 4/15/2026, 3:42:14 PM
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.sort(matrix[i]);
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    break;
                }
                maxArea = Math.max(maxArea, matrix[i][j] * (n - j));
            }
        }

        return maxArea;
        
    }
}