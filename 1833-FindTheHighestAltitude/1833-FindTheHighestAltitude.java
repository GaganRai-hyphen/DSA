// Last updated: 4/15/2026, 3:42:16 PM
class Solution {
    public int largestAltitude(int[] gain) {
        int max =0 , sum = 0;
       for(int m : gain ){
       sum+=m;
      max = Math.max(sum , max);
        }
        return max;
    }
}