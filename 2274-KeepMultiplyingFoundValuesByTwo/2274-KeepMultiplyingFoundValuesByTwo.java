// Last updated: 4/15/2026, 3:41:42 PM
class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while(i<n){
             if(nums[i]==original){
                 
                 original*=2;
                
                 }
                 i++;
        }
        return original;
    }
}