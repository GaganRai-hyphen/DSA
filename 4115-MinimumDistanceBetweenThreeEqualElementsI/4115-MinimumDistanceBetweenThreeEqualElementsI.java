// Last updated: 4/15/2026, 3:40:05 PM
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int minTotalDistance = Integer.MAX_VALUE;
        
        for (List<Integer> indices : map.values()) {
            if (indices.size() >= 3) {
                for (int i = 0; i <= indices.size() - 3; i++) {
                    int distance = 2 * (indices.get(i + 2) - indices.get(i));
                    minTotalDistance = Math.min(minTotalDistance, distance);
                }
            }
        }
        
        return minTotalDistance == Integer.MAX_VALUE ? -1 : minTotalDistance;
        
    }
}