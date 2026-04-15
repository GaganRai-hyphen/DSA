// Last updated: 4/15/2026, 3:42:57 PM
class Solution {
    public int repeatedNTimes(int[] nums) {
       Arrays.sort(nums);
        for(int i = 0 ; i < (2*nums.length) ; i++){
            if(nums[i] == nums[i+1]) return nums[i] ;
            
        }
        return 0;
    }
}