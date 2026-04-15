// Last updated: 4/15/2026, 3:40:18 PM
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for (int[] q : queries) {
            for (int idx = q[0]; idx <= q[1]; idx += q[2]) {
                nums[idx] = (int) (((long) nums[idx] * q[3]) % MOD);
            }
        }
        
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        
        return ans;
    }
}