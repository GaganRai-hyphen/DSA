class Solution {
    public int sortPermutation(int[] nums) {
      int ans = -1;
        boolean outOfPlace = false;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
                outOfPlace = true;
            }
        }
        
        return outOfPlace ? ans : 0;  
    }
}