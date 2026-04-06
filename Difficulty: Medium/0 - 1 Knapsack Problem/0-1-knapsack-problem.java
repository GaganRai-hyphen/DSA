class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
         int[][] dp = new int[n+1][W+1];
         
         for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++)
                dp[i][j] = -1;
        }
        
        return solve(W, val, wt, n , dp);
         
    }
    
    int solve(int W , int val[] , int wt[] , int n , int[][] dp ){
    
    if(W==0 || n == 0) return 0;
    
    if(dp[n][W] != -1)  return dp[n][W];
    
    if(wt[n-1] <= W){
        return dp[n][W] = Math.max(val[n - 1] + solve( W-wt[n-1] , val , wt , n-1 , dp ) , 
        solve( W , val , wt , n-1 , dp ) );
    }
    
    else return dp[n][W] = solve( W , val , wt , n-1 , dp ) ;
}
    
}
