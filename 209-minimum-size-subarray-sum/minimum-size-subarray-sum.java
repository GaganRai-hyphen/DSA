class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
       int i = 0 , j = 0 , sum = 0;

       while(j<nums.length){
         sum += nums[j];

         while(sum>=target ){
            min = Math.min(j-i+1 , min);
            sum -= nums[i];
           i++;
         } 
         j++;
       }
       if( min == 2147483647 ) min = 0;
       return min ;
    }
}