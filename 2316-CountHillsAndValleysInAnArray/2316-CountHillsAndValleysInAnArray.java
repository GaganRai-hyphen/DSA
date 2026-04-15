// Last updated: 4/15/2026, 3:41:36 PM
class Solution {
    public int countHillValley(int[] nums) {
        int c = 0 ;
        int n = nums.length;
        int prev = nums[0];
        for(int i = 1 ; i<n-1 ; i++){
         
         if((nums[i]>prev && nums[i]>nums[i+1]) || (nums[i]<prev && nums[i]<nums[i+1])){
             c++;
           prev = nums[i];
           }
        }

        return c;
    }
}