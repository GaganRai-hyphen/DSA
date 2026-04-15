// Last updated: 4/15/2026, 3:40:14 PM
class Solution {
      private int find(int[] parent, int i) {
        if (i >= parent.length) return i;
        int curr = i;
        while (parent[curr] != curr) {
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }
        return curr;
    }

    
    public int minOperations(String s, int k) {
         int n = s.length();
        int initialZeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                initialZeros++;
            }
        }
        if (initialZeros == 0) return 0;

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
        }
        dist[initialZeros] = 0;

        int[] nextEven = new int[n + 3];
        int[] nextOdd = new int[n + 3];
        for (int i = 0; i < n + 3; i++) {
            nextEven[i] = i;
            nextOdd[i] = i;
        }

        if (initialZeros % 2 == 0) {
            nextEven[initialZeros] = initialZeros + 2;
        } else {
            nextOdd[initialZeros] = initialZeros + 2;
        }

        int[] q = new int[n + 1];
        int head = 0, tail = 0;
        q[tail++] = initialZeros;

        while (head < tail) {
            int c = q[head++];

            int minX = Math.max(0, k - (n - c));
            int maxX = Math.min(c, k);

            int minNext = c - 2 * maxX + k;
            int maxNext = c - 2 * minX + k;

            int[] targetNext = (minNext % 2 == 0) ? nextEven : nextOdd;

            int curr = find(targetNext, minNext);
            while (curr <= maxNext) {
                dist[curr] = dist[c] + 1;
                if (curr == 0) return dist[0];
                q[tail++] = curr;
                targetNext[curr] = curr + 2;
                curr = find(targetNext, curr);
            }
        }

        return dist[0];
        
    }
}