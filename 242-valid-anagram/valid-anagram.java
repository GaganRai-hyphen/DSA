class Solution {
    public boolean isAnagram(String s, String t) {
       int S = s.length() , T = t.length();
       if(S!=T) return false;
       int[] charCounts = new int[26];
        
        for (int i = 0; i < S; i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}