// Last updated: 4/15/2026, 3:41:37 PM
class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int p = 0;
        for(int i = 0 ; i<nums.length-1;){
            if(nums[i] == nums[i+1]){
                p++;
                i+=2;
            }
            else i++;
        }
        return p == nums.length/2;
        
    }
}