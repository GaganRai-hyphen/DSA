// Last updated: 4/15/2026, 3:41:40 PM
class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int p = 0;
        for(int i = 0 ; i<n;i++){
         for(int j =i+1 ; j<n;j++){
          if(nums[i]==nums[j] && (i*j)%k==0) p++;
         }
        }
        return p;
    }
}