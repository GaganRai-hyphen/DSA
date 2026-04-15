// Last updated: 4/15/2026, 3:44:55 PM
class Solution {
    boolean isPalin(String s , int i , int j ,Boolean[][] dp){
     if(i>=j) return true;
    if(dp[i][j] != null) return dp[i][j];
     if(s.charAt(i)==s.charAt(j)) return dp[i][j]= isPalin(s , i+1 ,j-1 , dp);
     return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {
   int sp = 0 , maxLength = Integer.MIN_VALUE;
   int n = s.length();
   Boolean dp[][] = new Boolean[n+1][n+1];
   for(int i = 0 ; i<s.length() ; i++){
    for(int j = i ; j<s.length() ; j++){
        if(isPalin(s,i,j,dp)){
            if(j-i+1>maxLength){
                maxLength = j-i+1;
                sp = i ;
            }
        }
    }
   } 
   return s.substring(sp ,sp+maxLength);     
    }
}