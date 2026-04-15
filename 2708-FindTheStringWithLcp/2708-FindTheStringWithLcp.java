// Last updated: 4/15/2026, 3:41:14 PM
class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];
        char currentchar = 'a';

        for(int i = 0 ; i<n ; i++){
            if(word[i] == '\0'){
                if(currentchar > 'z') return "";
                word[i] = currentchar;
                for(int j = i+1 ; j<n ; j++){
                    if(lcp[i][j]>0) word[j] = currentchar;
                }
                currentchar++;
            }
            
        } 
        int[][] dp = new int[n+1][n+1];
        for(int i = n-1 ; i>=0 ; i--){
            for(int j = n-1 ; j>=0 ; j--){
                if(word[i] == word[j]) dp[i][j] = 1 + dp[i+1][j+1];
                if(dp[i][j] != lcp[i][j] ) return "";
            }

        }


        return new String(word);
    }
}