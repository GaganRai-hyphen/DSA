// Last updated: 4/15/2026, 3:40:48 PM
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1;
        long right = (long) workerTimes[0] * mountainHeight * (mountainHeight + 1) / 2;
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    private boolean check(long mid, int mountainHeight, int[] workerTimes) {
        long totalHeight = 0;
        for (int t : workerTimes) {
            long l = 0;
            long r = mountainHeight;
            long h = 0;
            
            while (l <= r) {
                long m = l + (r - l) / 2;
                if (m * (m + 1) / 2 <= mid / t) {
                    h = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            
            totalHeight += h;
            if (totalHeight >= mountainHeight) {
                return true;
            }
        }
        return false;
        
    }
}