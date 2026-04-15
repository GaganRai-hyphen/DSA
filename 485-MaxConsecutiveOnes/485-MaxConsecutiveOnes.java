// Last updated: 4/15/2026, 3:43:41 PM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0 ;
        int c = 0 ;
        for(int i = 0; i<nums.length; i++ ){
            if(nums[i]==1){
                c++;
                 if(maxCount<c) maxCount=c;
            }
            else{
                if(maxCount<c) maxCount=c;
                c=0;
            }
        }
        return maxCount;
    }
}