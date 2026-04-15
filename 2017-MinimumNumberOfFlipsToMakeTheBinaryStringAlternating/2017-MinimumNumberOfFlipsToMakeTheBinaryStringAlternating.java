// Last updated: 4/15/2026, 3:42:02 PM
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int minFlips = Integer.MAX_VALUE;
        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < 2 * n; i++) {
            char c = s.charAt(i % n);
            char expected1 = i % 2 == 0 ? '1' : '0';
            char expected2 = i % 2 == 0 ? '0' : '1';

            if (c != expected1) diff1++;
            if (c != expected2) diff2++;

            if (i >= n) {
                char leftChar = s.charAt((i - n) % n);
                char leftExpected1 = (i - n) % 2 == 0 ? '1' : '0';
                char leftExpected2 = (i - n) % 2 == 0 ? '0' : '1';
                
                if (leftChar != leftExpected1) diff1--;
                if (leftChar != leftExpected2) diff2--;
            }

            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }

        return minFlips;
        
    }
}