class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        int maxDiff = 0;
        int[] diffs = new int[n];
        long sumDiff = 0;

        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            sumDiff += diffs[i];
            maxDiff = Math.max(maxDiff, diffs[i]);
        }

        if (sumDiff <= totalK) {
            return 0;
        }

        long[] freq = new long[maxDiff + 1];
        for (int d : diffs) {
            freq[d]++;
        }

        for (int i = maxDiff; i > 0 && totalK > 0; i--) {
            if (freq[i] > 0) {
                long take = Math.min(freq[i], totalK);
                freq[i] -= take;
                freq[i - 1] += take;
                totalK -= take;
            }
        }

        long ans = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (freq[i] > 0) {
                ans += freq[i] * (long) i * i;
            }
        }

        return ans;
    }
}