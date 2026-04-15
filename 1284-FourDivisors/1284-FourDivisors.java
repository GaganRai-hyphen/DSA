// Last updated: 4/15/2026, 3:42:49 PM
class Solution {
   
   boolean PerfectSquare(int n){
    int sqrt = (int)Math.sqrt(n);
    if(sqrt*sqrt == n) return true;
    return false;
   }

    public int sumFourDivisors(int[] nums) {
     int ans = 0;

     for(int i = 0  ; i < nums.length ; i++){
     int num  = nums[i]; 
     int c = 0 ;
     int sum = 0;
     for(int div = 1 ; div*div <= num ; div++){
        if(num % div == 0 ){
             c+=2; ;
             sum += (div + num/div);
        }
        if( c > 4) break;
        }
        if(c == 4 && !PerfectSquare(num)) ans += sum;
     }
     return ans;
    }
}