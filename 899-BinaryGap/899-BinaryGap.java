// Last updated: 4/15/2026, 3:43:04 PM
class Solution {
    public int binaryGap(int n) {
        String b = Integer.toBinaryString(n);
        int max = 0;
        int lastPos = -1;

        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                if (lastPos != -1) {
                    max = Math.max(max, i - lastPos);
                }
                lastPos = i;
            }
        }
        return max;
    }
}