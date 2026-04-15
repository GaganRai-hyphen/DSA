// Last updated: 4/15/2026, 3:43:12 PM
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int c  = 0;
        for(int i =0; i<m-2 ; i++){
            for(int j = 0 ; j<n-2 ; j++){
                if(isMagic(i , j , grid))c++;
            }
        }
        return c;
    }
     boolean isMagic(int row , int col ,  int[][] grid){
        int m = grid.length , n = grid[0].length;
        boolean check[] = new boolean[10];
       for(int i=0 ; i<3 ; i++ ){
        for(int j = 0 ; j<3 ; j++){

            int cell = grid[row+i][col+j];

            if(cell<1 || cell>9 || check[cell]) return false;
            check[cell] = true;
        }
       }
       for(int i = 0 ; i<3 ; i++){
        if(grid[row+i][col] + grid[row+i][col+1] + grid[row+i][col+2] != 15 ) return false;
       }
        for(int j = 0 ; j<3 ; j++){
        if(grid[row][col+j] + grid[row+1][col+j] + grid[row+2][col+j] != 15 ) return false;
        }
        if (grid[row][col] +
            grid[row + 1][col + 1] +
            grid[row + 2][col + 2] != 15) {
            return false;
        }
         if (grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2] != 15) {
            return false;
        }
        return true;
    }
}