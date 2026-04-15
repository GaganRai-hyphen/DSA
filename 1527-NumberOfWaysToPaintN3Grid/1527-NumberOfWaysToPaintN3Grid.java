// Last updated: 4/15/2026, 3:42:31 PM
class Solution {
    public int numOfWays(int n) {
        long mod = 1_000_000_007;
        long aba = 6;
        long abc = 6;

        for (int i = 2; i <= n; i++) {
            long prevAba = aba;
            long prevAbc = abc;

            aba = (3 * prevAba + 2 * prevAbc) % mod;
            abc = (2 * prevAba + 2 * prevAbc) % mod;
        }

        return (int) ((aba + abc) % mod);
    }
}