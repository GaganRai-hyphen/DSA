class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        
        int maxVal = 0;
        for (int x : nums) {
            if (x > maxVal) {
                maxVal = x;
            }
        }
        
        int[] spf = new int[maxVal + 1];
        for (int i = 2; i <= maxVal; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (temp > 1) {
                int p = spf[temp];
                edges.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (temp % p == 0) {
                    temp /= p;
                }
            }
        }
        
        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        seen[0] = true;
        
        int jumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                if (curr == n - 1) return jumps;
                
                if (curr - 1 >= 0 && !seen[curr - 1]) {
                    seen[curr - 1] = true;
                    queue.offer(curr - 1);
                }
                
                if (curr + 1 < n && !seen[curr + 1]) {
                    seen[curr + 1] = true;
                    queue.offer(curr + 1);
                }
                
                int val = nums[curr];
                if (val >= 2 && spf[val] == val) {
                    List<Integer> targets = edges.remove(val);
                    if (targets != null) {
                        for (int next : targets) {
                            if (!seen[next]) {
                                seen[next] = true;
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            jumps++;
        }
        
        return -1;
    }
}