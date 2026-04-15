// Last updated: 4/15/2026, 3:43:58 PM
class Solution {
    public int countPrimes(int n) {
        if(n<3) return 0 ;
        int c = n-2;
        boolean prime[] = new boolean[n];
        Arrays.fill(prime , true);
        prime[0] = prime[1] =  false;
       
        for(int i = 2 ; i*i <= n ;i++){
            if(!prime[i]) continue;
                for(int j = i*i ; j<n ; j=j+i){
                    if(prime[j]){
                    prime[j]=false;
                    c--;
              }
              }
            }
        
       
        return c ;
    }
}