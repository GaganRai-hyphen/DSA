// Last updated: 4/15/2026, 3:42:59 PM
class Solution {
    public int superEggDrop(int k, int n) {
     int[][] dp = new int[n+1][k+1];
     int moves = 0;
     while(dp[moves][k]<n){
       moves++;
       for(int i = 1 ; i <= k ; i++){
        dp[moves][i]= dp[moves-1][i-1] + 1 + dp[moves-1][i];

       }
     } 
     return moves;
    }
}