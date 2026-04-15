// Last updated: 4/15/2026, 3:42:34 PM
class Solution {
    public String getHappyString(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";

        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        k--;

        for (int i = 0; i < n; i++) {
            int groupSize = 1 << (n - 1 - i);
            int index = k / groupSize;
            k %= groupSize;

            int count = 0;
            for (char c = 'a'; c <= 'c'; c++) {
                if (c == prev) continue;
                if (count == index) {
                    sb.append(c);
                    prev = c;
                    break;
                }
                count++;
            }
        }
        return sb.toString();
        
    }
}