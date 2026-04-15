// Last updated: 4/15/2026, 3:41:48 PM
class Solution {
    public int smallestEqual(int[] nums) {
       
        int n = nums.length;
        for(int i = 0 ; i<n; i++){
            if(i%10==nums[i]){
                return i;
                
            }
            
        }
        return -1;
        
    }
}