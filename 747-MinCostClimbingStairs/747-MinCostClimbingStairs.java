// Last updated: 4/15/2026, 3:43:32 PM
class Solution {
    public int fn(int cost[] , int n , Integer[] dp){
        if(n<=1) return cost[n];
        if(dp[n]!=null) return dp[n];
        return dp[n] = Math.min(fn(cost , n-1 , dp) , fn(cost , n-2 , dp)) + cost[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[n+1];
        return Math.min(fn(cost , n-1 , dp) , fn(cost , n-2 , dp));
    }
    
}