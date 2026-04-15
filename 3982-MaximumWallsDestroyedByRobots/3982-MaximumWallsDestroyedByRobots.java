// Last updated: 4/15/2026, 3:40:15 PM
class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] r = new int[n][2];
        for (int i = 0; i < n; i++) {
            r[i][0] = robots[i];
            r[i][1] = distance[i];
        }
        
        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);

        int baseDestroyed = 0;
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(walls, r[i][0]) >= 0) {
                baseDestroyed++;
            }
        }

        int prevL = getWalls(walls, (long) r[0][0] - r[0][1], r[0][0] - 1);
        int prevR = 0;

        for (int i = 1; i < n; i++) {
            long A = r[i - 1][0];
            long D_prev = r[i - 1][1];
            long B = r[i][0];
            long D_curr = r[i][1];

            long i1Left = A + 1;
            long i1Right = Math.min(B - 1, A + D_prev);
            int wI1 = getWalls(walls, i1Left, i1Right);

            long i2Left = Math.max(A + 1, B - D_curr);
            long i2Right = B - 1;
            int wI2 = getWalls(walls, i2Left, i2Right);

            long interLeft = Math.max(i1Left, i2Left);
            long interRight = Math.min(i1Right, i2Right);
            int wInter = getWalls(walls, interLeft, interRight);

            int wUnion = wI1 + wI2 - wInter;

            int currL = Math.max(prevL + wI2, prevR + wUnion);
            int currR = Math.max(prevL, prevR + wI1);

            prevL = currL;
            prevR = currR;
        }

        int ansL = prevL;
        int ansR = prevR + getWalls(walls, (long) r[n - 1][0] + 1, (long) r[n - 1][0] + r[n - 1][1]);

        return baseDestroyed + Math.max(ansL, ansR);
    }

    private int getWalls(int[] walls, long left, long right) {
        if (left > right) return 0;
        return upperBound(walls, right) - lowerBound(walls, left);
    }

    private int lowerBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private int upperBound(int[] arr, long target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > target) high = mid;
            else low = mid + 1;
        }
        return low;
        
    }
}