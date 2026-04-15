// Last updated: 4/15/2026, 3:42:30 PM
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int requiredCount = 1 << k;
        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
            if (seen.size() == requiredCount) {
                return true;
            }
        }

        return false;
    }
}