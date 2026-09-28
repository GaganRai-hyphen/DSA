class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
           maxSum = Math.max(currentSum , maxSum);

           currentSum = Math.max(currentSum , 0);
        }
        
        return maxSum;
    }
}