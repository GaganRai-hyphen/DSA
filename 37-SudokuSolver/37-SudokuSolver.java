// Last updated: 4/15/2026, 3:44:42 PM
class Solution {
    public boolean isValid(char[][] board , int row , int col , char num){
        for(int k = 0 ; k<9 ; k++){
            if(board[row][k] == num || board[k][col] == num) return false;
        }

            int sR = (row/3)*3 , sC = (col/3)*3;
            for(int i = sR ; i < sR+3 ; i++ ){
                for(int j = sC ; j < sC+3 ; j++){
                    if(board[i][j] == num) return false;
                
            }
        }
        return true;
    }
    public boolean solve(char[][] board , int row , int col ){
        if(row == 9) return true;
        if(col == 9) return solve(board , row+1 , 0 ) ;
        if(board[row][col] != '.') return solve(board , row , col+1  ) ;

        for(char num = '1' ; num <= '9' ; num++){
            if(isValid(board , row , col , num)){

                board[row][col] = num;
                if(solve(board , row , col+1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board , 0 , 0);
    }
}