// Last updated: 4/15/2026, 3:41:19 PM
class Solution {
    public int minimumOperations(int[] nums) {
        int c = 0 ;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
            for(int j = i ; j<n ;j++){
                nums[j] = nums[j] - temp;
            }
            c++;
            }
        }

       return c; 
    }
}