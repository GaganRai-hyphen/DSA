// Last updated: 4/15/2026, 3:44:00 PM
class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer>list = new  ArrayList<>();
        while(true){
            int sum = 0;
            while(n>0){
            int lst = n%10;
            sum+= lst * lst ;
            n/=10;
            }
            if(sum==1) return true;
            else if(list.contains(sum)) return false ;

            list.add(sum);
            n = sum;
        }
        
    }
}