// Last updated: 4/15/2026, 3:40:16 PM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int MOD = 1000000007;

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int BLOCK = 316;
        
        List<int[]>[] smallQueries = new ArrayList[BLOCK];
        for (int i = 1; i < BLOCK; i++) {
            smallQueries[i] = new ArrayList<>();
        }
        
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            
            if (k >= BLOCK) {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * v) % MOD);
                }
            } else {
                smallQueries[k].add(q);
            }
        }
        
        long[] pref = new long[n];
        
        for (int k = 1; k < BLOCK; k++) {
            if (smallQueries[k].isEmpty()) continue;
            
            Arrays.fill(pref, 1L);
            
            for (int[] q : smallQueries[k]) {
                int l = q[0], r = q[1], v = q[3];
                pref[l] = (pref[l] * v) % MOD;
                
                int steps = (r - l) / k;
                int next_idx = l + (steps + 1) * k;
                
                if (next_idx < n) {
                    pref[next_idx] = (pref[next_idx] * modInverse(v)) % MOD;
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    pref[i] = (pref[i] * pref[i - k]) % MOD;
                }
                nums[i] = (int) ((1L * nums[i] * pref[i]) % MOD);
            }
        }
        
        int final_xor = 0;
        for (int i = 0; i < n; i++) {
            final_xor ^= nums[i];
        }
        
        return final_xor;
    }
}
