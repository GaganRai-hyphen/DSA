class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int k = 1; k < strs.length; k++) {
            prefix = lcp(prefix, strs[k]);
        }
        
        return prefix;
    }
    private String lcp(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i++;
                j++;
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}