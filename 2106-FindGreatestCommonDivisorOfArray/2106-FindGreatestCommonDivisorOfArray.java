// Last updated: 4/15/2026, 3:41:58 PM
class Solution {
    public static int gcd(int a, int b ){
        if(b==0) return a;
        return gcd(b , a%b); 
    } 
    public int findGCD(int[] nums) {
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
        for(int n : nums){
            if(n>max){
                max = n;
            }
            if(n<min) min = n;
        }
        return gcd(max,min);
    }
}