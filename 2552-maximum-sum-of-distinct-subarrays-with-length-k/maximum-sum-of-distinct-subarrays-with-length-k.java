class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0, max = 0;

        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        if (map.size() == k) {
            max = sum;
        }

        for (int i = k; i < nums.length; i++) {
            int numToAdd = nums[i];
            int numToRem = nums[i - k];

            map.put(numToAdd, map.getOrDefault(numToAdd, 0) + 1);
            sum += numToAdd;

            map.put(numToRem, map.get(numToRem) - 1);
            if (map.get(numToRem) == 0) {
                map.remove(numToRem);
            }
            sum -= numToRem;

            if (map.size() == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}