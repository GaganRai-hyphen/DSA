// Last updated: 4/15/2026, 3:44:24 PM
class Solution {
    public int climbStairs(int n) {
        Integer dp[] = new Integer[n+1];
        return ans(n , dp);
    }
    int ans(int n , Integer dp[]){
        if(n==1 || n==0) return 1;
        if(dp[n] != null) return dp[n];
        return dp[n] = ans(n-1 , dp) + ans(n-2, dp) ; 
    }
}