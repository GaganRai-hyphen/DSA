// Last updated: 4/15/2026, 3:41:45 PM
class Solution {
    public boolean checkString(String s) {
        for(int i = 0 ; i<s.length() ; i++){
            if(s.indexOf('a')== -1 || s.indexOf('b')== -1 ){
                return true;
            }
            else if(s.lastIndexOf('a')<s.indexOf('b')){
                return true;
            }
        
        }
         return false;
    }
}