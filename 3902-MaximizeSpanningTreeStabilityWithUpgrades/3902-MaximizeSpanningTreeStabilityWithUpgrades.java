// Last updated: 4/15/2026, 3:40:25 PM
class Solution {
    public int maxStability(int n, int[][] edges, int k) {
       int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int comps = n;
        long minMust = Long.MAX_VALUE;
        long maxS = 0;

        for (int[] e : edges) {
            maxS = Math.max(maxS, e[2]);
            if (e[3] == 1) {
                int rx = find(parent, e[0]);
                int ry = find(parent, e[1]);
                if (rx == ry) return -1;
                parent[rx] = ry;
                comps--;
                minMust = Math.min(minMust, e[2]);
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0) {
                int rx = find(parent, e[0]);
                int ry = find(parent, e[1]);
                if (rx != ry) {
                    parent[rx] = ry;
                    comps--;
                }
            }
        }

        if (comps > 1) return -1;

        long left = 1;
        long right = Math.min(minMust, maxS * 2);
        long ans = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mid, n, edges, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) ans;
    }

    private boolean check(long x, int n, int[][] edges, int k) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int comps = n;

        for (int[] e : edges) {
            if (e[3] == 1) {
                int rx = find(parent, e[0]);
                int ry = find(parent, e[1]);
                if (rx != ry) {
                    parent[rx] = ry;
                    comps--;
                }
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= x) {
                int rx = find(parent, e[0]);
                int ry = find(parent, e[1]);
                if (rx != ry) {
                    parent[rx] = ry;
                    comps--;
                }
            }
        }

        int upgrades = 0;
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < x && e[2] * 2L >= x) {
                int rx = find(parent, e[0]);
                int ry = find(parent, e[1]);
                if (rx != ry) {
                    parent[rx] = ry;
                    comps--;
                    upgrades++;
                }
            }
        }

        return comps == 1 && upgrades <= k;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
     
    }
}