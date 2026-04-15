// Last updated: 4/15/2026, 3:41:23 PM
class Solution {
    public int countAsterisks(String s) {
        int bar = 0;
        int star = 0;
         for(int i = 0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
          if(ch == '|'){ bar++;}
          else if(ch == '*' && bar%2==0 ){ star++;}
         }
        return star;
    }
}