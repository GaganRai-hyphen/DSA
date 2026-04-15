// Last updated: 4/15/2026, 3:44:44 PM
class Solution {
    public int searchInsert(int[] nums, int target) {
         int f = 0 , l = nums.length-1 ;
       while(f<=l){
           int mid = f + (l-f)/2;
            if(nums[mid]==target){
               return mid;
            } 
            else if(nums[mid]<target){
                f=mid+1;
            }
            else {
             l = mid-1;
            }
        }  
        return f;
    }
}