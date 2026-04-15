// Last updated: 4/15/2026, 3:43:03 PM
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
       int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int x = 0;
        int y = 0;
        int maxDist = 0;

        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(((long) obs[0] << 32) | (obs[1] & 0xFFFFFFFFL));
        }

        for (int cmd : commands) {
            if (cmd == -1) {
                d = (d + 1) % 4;
            } else if (cmd == -2) {
                d = (d + 3) % 4;
            } else {
                for (int step = 0; step < cmd; step++) {
                    int nx = x + dirs[d][0];
                    int ny = y + dirs[d][1];
                    long code = ((long) nx << 32) | (ny & 0xFFFFFFFFL);
                    
                    if (obstacleSet.contains(code)) {
                        break;
                    }
                    
                    x = nx;
                    y = ny;
                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
        
    }
}