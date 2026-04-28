class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = grid[i][j];
            }
        }
        
        Arrays.sort(arr);
        
        int mod = arr[0] % x;
        int median = arr[arr.length / 2];
        int operations = 0;
        
        for (int num : arr) {
            if (num % x != mod) {
                return -1;
            }
            operations += Math.abs(num - median) / x;
        }
        
        return operations;
    }
}