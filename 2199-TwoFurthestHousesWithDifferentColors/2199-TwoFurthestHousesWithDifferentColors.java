// Last updated: 4/15/2026, 3:41:46 PM
class Solution {
    public int maxDistance(int[] colors) {
        
        int ans = 0 ;
        for(int i = 0  ; i<colors.length ; i++){
            for(int j = colors.length-1 ; j>=0 ; j-- ){
                if(colors[i]!=colors[j]){
                   ans = Math.max( j-i , ans);
                }
            }
        }
        return ans; 
    }
}