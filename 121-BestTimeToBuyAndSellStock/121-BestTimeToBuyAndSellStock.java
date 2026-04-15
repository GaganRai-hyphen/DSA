// Last updated: 4/15/2026, 3:44:10 PM
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0] , ans = 0;
        for(int price : prices){
            ans = Math.max(ans , price-min);
            min = Math.min(min , price);
        }
        return ans;
    }
}