// Last updated: 4/15/2026, 3:41:43 PM
class Solution {
    public int minimumSum(int num) {
        int [] arr  = new int[4];
        int i = 3;

        while(num!=0){
            int last = num%10;
            arr[i--] = last ;
            num/=10;  
        }
        Arrays.sort(arr);
        return (arr[0]*10 + arr[2] ) + (arr[1]*10 + arr[3]);
        
    }
}