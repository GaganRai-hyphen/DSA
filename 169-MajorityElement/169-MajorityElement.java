// Last updated: 4/15/2026, 3:44:04 PM
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int candi = nums[0];
        int vote = 1 ;

        for(int i = 1 ; i<n ;i++){
            if(vote==0){
                candi = nums[i];
                vote = 1;
            }

            else if(candi == nums[i]){
                vote++;
            }
            else vote--;
        }
        return candi;
        
    }
}