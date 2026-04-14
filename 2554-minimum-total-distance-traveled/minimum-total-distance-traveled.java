class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = robot.size();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;
        
        for (int[] f : factory) {
            for (int i = n; i >= 1; i--) {
                long dist = 0;
                for (int k = 1; k <= f[1] && i - k >= 0; k++) {
                    dist += Math.abs(robot.get(i - k) - f[0]);
                    dp[i] = Math.min(dp[i], dp[i - k] + dist);
                }
            }
        }
        
        return dp[n];
    }
}