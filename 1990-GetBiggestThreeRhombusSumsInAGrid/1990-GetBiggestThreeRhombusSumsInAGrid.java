// Last updated: 4/15/2026, 3:42:05 PM
class Solution {
    public int[] getBiggestThree(int[][] grid) {
      int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set.add(grid[i][j]);
                if (set.size() > 3) {
                    set.pollFirst();
                }

                int maxL = Math.min(Math.min(j, n - 1 - j), (m - 1 - i) / 2);
                for (int L = 1; L <= maxL; L++) {
                    int sum = 0;
                    int x = i, y = j;
                    
                    for (int k = 0; k < L; k++) sum += grid[x++][y--];
                    for (int k = 0; k < L; k++) sum += grid[x++][y++];
                    for (int k = 0; k < L; k++) sum += grid[x--][y++];
                    for (int k = 0; k < L; k++) sum += grid[x--][y--];

                    set.add(sum);
                    if (set.size() > 3) {
                        set.pollFirst();
                    }
                }
            }
        }

        int[] res = new int[set.size()];
        int idx = set.size() - 1;
        for (int num : set) {
            res[idx--] = num;
        }
        
        return res;  
    }
}