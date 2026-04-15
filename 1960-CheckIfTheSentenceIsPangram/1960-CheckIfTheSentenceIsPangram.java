// Last updated: 4/15/2026, 3:42:09 PM
class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set  = new HashSet<>();
        for(int i = 0 ; i<sentence.length() ; i++){
            char ch = sentence.charAt(i);
            set.add(ch);
        }
        return set.size() == 26;
    }
}