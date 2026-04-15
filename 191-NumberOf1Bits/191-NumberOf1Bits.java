// Last updated: 4/15/2026, 3:44:01 PM
class Solution {
    public int hammingWeight(int n) {
        int count = Integer.bitCount(n);
        return count;
    }
}