// Last updated: 4/15/2026, 3:43:16 PM
class Solution {
    public int search(int[] nums, int target) {
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
        return -1;
    }
}