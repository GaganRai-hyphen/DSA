// Last updated: 4/15/2026, 3:42:12 PM
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count0 = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            if (chars[i] != (i % 2 == 0 ? '0' : '1')) {
                count0++;
            }
        }

        return Math.min(count0, n - count0);
        
    }
}