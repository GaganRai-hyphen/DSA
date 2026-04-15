// Last updated: 4/15/2026, 3:41:26 PM
class Solution {
    public boolean digitCount(String num) {
        int[] freq = new int[10];
        int n = num.length();
        for(char ch : num.toCharArray()){
             freq[ch-'0']++;
        }
        for(int i = 0; i<n ;i++){
            if(freq[i] != num.charAt(i)-'0'){
                return false;
            }
        }
        return true;
    }
}