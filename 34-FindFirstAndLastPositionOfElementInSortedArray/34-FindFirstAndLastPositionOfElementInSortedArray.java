// Last updated: 4/15/2026, 3:44:45 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f =0 , l = nums.length-1 , fo = -1 , lo = -1;
        while(f<=l){
            int mid = f + (l-f)/2;
            if(nums[mid]==target){
                fo = mid;
                l = mid-1;
            }
            else if(target > nums[mid]){
                f = mid+1;
            }
            else l = mid - 1; 
        }
        f = 0;
        l = nums.length-1;
        while(f<=l){
            int mid = f + (l-f)/2;
            if(nums[mid]==target){
                lo = mid;
                f = mid+1;
            }
            else if(target > nums[mid]){
                f = mid+1;
            }
            else l = mid - 1; 
        }
        return new int[]{fo,lo} ;
    }
}