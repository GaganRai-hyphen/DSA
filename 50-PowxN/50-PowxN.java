// Last updated: 4/15/2026, 3:44:40 PM
class Solution {
    public double pow(double x , int n ){
         if( n == 0 )return 1;
        if( n == 1) return x;
        double r = pow(x ,n/2);
        return (n%2==0) ? r*r : r*r*x;
    }
    public double myPow(double x, int n) {
    boolean isneg = false ; 
    if(n<0){
        isneg = true;
        n*= -1;
    }
    double ans = pow(x , n);
    return isneg ? 1/ans : ans ;
    }
}