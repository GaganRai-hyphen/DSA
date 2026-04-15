// Last updated: 4/15/2026, 3:40:21 PM
class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 0;
        int ans = n;
        
        while(left < n) {
            while(right < n && nums[right] <= (long)k * nums[left]) {
                right++;
            }
           
            ans = Math.min(ans, n - (right - left));
           
            left++;
        }

        return ans;
    }
}