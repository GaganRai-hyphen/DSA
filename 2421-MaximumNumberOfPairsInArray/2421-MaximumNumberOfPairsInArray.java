// Last updated: 4/15/2026, 3:41:22 PM
class Solution {
    public int[] numberOfPairs(int[] nums) {
        Arrays.sort(nums);
        int p = 0 , n = nums.length;
        for(int i = 0 ; i<n-1;){
            if(nums[i]==nums[i+1]){
                p++;
                i+=2;

            }
            else i++;
        }
        return new int[]{p , n-p*2};
        
    }
}