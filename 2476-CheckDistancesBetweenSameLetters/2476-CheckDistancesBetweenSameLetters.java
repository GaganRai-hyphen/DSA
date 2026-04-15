// Last updated: 4/15/2026, 3:41:18 PM
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for(char ch : s.toCharArray() ){
            int last  = s.lastIndexOf(ch);
            int first  = s.indexOf(ch);
            int dist = last-first-1;
            if(distance[ch-97] != dist) return false ;
        }
        return true;
    }
}