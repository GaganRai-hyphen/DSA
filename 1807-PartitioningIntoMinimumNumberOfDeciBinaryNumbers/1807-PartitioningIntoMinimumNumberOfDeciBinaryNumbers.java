// Last updated: 4/15/2026, 3:42:17 PM
class Solution {
    public int minPartitions(String n) {
       int max = 0;
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            if (digit > max) {
                max = digit;
            }
            if (max == 9) break;
        }
        return max;
        
    }
}