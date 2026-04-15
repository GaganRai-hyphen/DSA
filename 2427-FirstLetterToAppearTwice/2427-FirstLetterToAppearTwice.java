// Last updated: 4/15/2026, 3:41:21 PM
class Solution {
    public char repeatedCharacter(String s) {
         HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i<s.length();i++){
        
            if(set.contains(s.charAt(i))) return s.charAt(i);
            else set.add(s.charAt(i));
        }
        return 0;
    }
}