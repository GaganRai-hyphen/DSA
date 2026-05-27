class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lowercase = new boolean[26];
        boolean[] uppercase = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowercase[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                uppercase[ch - 'A'] = true;
            }
        }

        int specialCount = 0;
        for (int i = 0; i < 26; i++) {
            if (lowercase[i] && uppercase[i]) {
                specialCount++;
            }
        }

        return specialCount;
    }
}