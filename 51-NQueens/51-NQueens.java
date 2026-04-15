// Last updated: 4/15/2026, 3:44:39 PM
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int arr[][] = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        solve(arr , ans , n , 0);
        return ans;
    }
    void solve(int[][] arr , List<List<String>> ans , int n , int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n ; i++){
                String cur = "";
                for(int j = 0 ; j<n ; j++){
                    if(arr[i][j] == 1) cur += "Q";
                    else cur += ".";
                }
                list.add(cur);
            }
            ans.add(list);
            return ;
        }
        for(int col = 0 ; col<n ; col++){
            if(isValid(arr , col ,row )){
                arr[row][col] = 1;
                solve(arr , ans , n , row+1);
                arr[row][col] = 0 ;
            }
        }
    }
    boolean isValid(int arr[][] , int col , int row){
        int i = row , j = col ;
        while(i>=0){
            if(arr[i--][j]==1) return false;
        }
        i=row;
        j=col;

        while(i>=0 && j>=0){
            if(arr[i--][j--]==1) return false;
        }
        i=row;
        j=col;

        while(i>=0 && j<arr.length){
            if(arr[i--][j++]==1) return false;
        }
        return true;
    }
}