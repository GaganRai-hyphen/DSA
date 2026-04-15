// Last updated: 4/15/2026, 3:40:31 PM
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        for (int[] row : grid) {
            for (int val : row) {
                totalSum += val;
            }
        }

        if (check(grid, totalSum)) return true;
        if (check(reverseRows(grid), totalSum)) return true;

        int[][] transposed = transpose(grid);
        if (check(transposed, totalSum)) return true;
        if (check(reverseRows(transposed), totalSum)) return true;

        return false;
    }

    private boolean check(int[][] mat, long totalSum) {
        int m = mat.length;
        int n = mat[0].length;
        long topSum = 0;
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                topSum += mat[i][j];
                seen.add(mat[i][j]);
            }
            long botSum = totalSum - topSum;
            long diff = topSum - botSum;

            if (diff == 0) return true;
            
            // 100000 is max grid value. This prevents long -> int overflow matching
            if (diff > 0 && diff <= 100000 && seen.contains((int) diff)) {
                if (i == 0) { 
                    // Top part is exactly 1 horizontal row
                    if (mat[0][0] == diff || mat[0][n - 1] == diff) return true;
                } else if (n == 1) { 
                    // Top part is exactly 1 vertical column
                    if (mat[0][0] == diff || mat[i][0] == diff) return true;
                } else { 
                    // Top part is a 2D matrix (m > 1 and n > 1)
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] transpose(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = mat[i][j];
            }
        }
        return res;
    }

    private int[][] reverseRows(int[][] mat) {
        int m = mat.length;
        int[][] res = new int[m][];
        // Shallow copy for row references is O(N) and memory efficient
        for (int i = 0; i < m; i++) {
            res[i] = mat[m - 1 - i];
        }
        return res;
    }
}