class Solution {
    public int minimumDistance(int[] nums) {
        int[] lastSeen = new int[100005];
        int[] secondLastSeen = new int[100005];
        
        Arrays.fill(lastSeen, -1);
        Arrays.fill(secondLastSeen, -1);
        
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            
            if (secondLastSeen[val] != -1) {
                minDistance = Math.min(minDistance, 2 * (i - secondLastSeen[val]));
            }
            
            secondLastSeen[val] = lastSeen[val];
            lastSeen[val] = i;
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}