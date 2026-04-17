class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int minDist = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int dist = i - map.get(nums[i]);
                minDist = Math.min(minDist, dist);
            }

            int reversedValue = reverseNumber(nums[i]);
            map.put(reversedValue, i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private int reverseNumber(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}