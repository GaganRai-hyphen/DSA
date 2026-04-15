// Last updated: 4/15/2026, 3:43:54 PM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i = 0 ; i < nums.length ; i++ ){
        if(s.contains(nums[i])) return true;
            s.add(nums[i]);
        }

        return false;
    }
}