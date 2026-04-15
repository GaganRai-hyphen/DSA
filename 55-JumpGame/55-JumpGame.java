// Last updated: 4/15/2026, 3:44:34 PM
class Solution {
    public boolean fn(int[] nums , int i , Boolean[] dp){
        if(i == nums.length-1) return true;
        if(dp[i] != null) return dp[i];
        boolean ans = false;
        for(int j = 1 ; j <= nums[i] ; j++){
            if(j+i < nums.length ){
                ans = fn(nums , j+i , dp);
            }
            if(ans) break ;
            }
            return dp[i] = ans;
        
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return fn(nums , 0 , dp);  
        
    }
}