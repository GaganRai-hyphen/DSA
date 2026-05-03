class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        StringBuilder sb = new StringBuilder(s);
        int n = s.length();

        while(n-- > 0 ){
            if(sb.toString().equals(goal)) return true;
            char ch = sb.charAt(0);
            sb.append(ch);
            sb.deleteCharAt(0);
        }
        return false;
    }
}