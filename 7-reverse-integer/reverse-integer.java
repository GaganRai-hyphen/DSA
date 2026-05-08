class Solution {
    public int reverse(int x) {
        int num = Math.abs(x);
        int n = 0  ;
        
        while(num!=0){
            int ld = num%10;
            if (n > (Integer.MAX_VALUE - ld) / 10) {
                return 0; 
            }
            n =  n*10 + ld;
            num/=10;
        }
       return (x < 0) ? (-n) : n;
    }
}