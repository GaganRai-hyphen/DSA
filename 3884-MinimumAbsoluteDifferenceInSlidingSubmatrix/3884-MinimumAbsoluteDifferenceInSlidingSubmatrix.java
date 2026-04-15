// Last updated: 4/15/2026, 3:40:29 PM
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int rowRes = m - k + 1;
        int colRes = n - k + 1;
        int[][] ans = new int[rowRes][colRes];

        for (int i = 0; i < rowRes; i++) {
            for (int j = 0; j < colRes; j++) {
                List<Integer> list = new ArrayList<>();
                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        list.add(grid[r][c]);
                    }
                }
                
                Collections.sort(list);
                
                int minDiff = Integer.MAX_VALUE;
                boolean hasDistinct = false;
                
                for (int t = 1; t < list.size(); t++) {
                    int diff = list.get(t) - list.get(t - 1);
                    if (diff > 0) {
                        if (diff < minDiff) minDiff = diff;
                        hasDistinct = true;
                    }
                }
                
                ans[i][j] = hasDistinct ? minDiff : 0;
            }
        }
        
        return ans;
        
    }
}