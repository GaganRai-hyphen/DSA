class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        int[] inTime = new int[n];
        int[] outTime = new int[n];
        int[] depth = new int[n];
        int[][] up = new int[n][17];
        int[] parent = new int[n];
        int[] edgeIdx = new int[n];
        int[] st = new int[n];
        
        int timer = 0;
        int top = 0;
        st[top] = 0;
        parent[0] = 0;
        
        while (top >= 0) {
            int u = st[top];
            if (edgeIdx[u] == 0) {
                inTime[u] = ++timer;
                int p = parent[u];
                depth[u] = (u == 0) ? 0 : depth[p] + 1;
                up[u][0] = p;
                for (int i = 1; i < 17; i++) {
                    up[u][i] = up[up[u][i - 1]][i - 1];
                }
            }
            if (edgeIdx[u] < adj[u].size()) {
                int v = adj[u].get(edgeIdx[u]++);
                if (v != parent[u]) {
                    parent[v] = u;
                    st[++top] = v;
                }
            } else {
                outTime[u] = timer;
                top--;
            }
        }
        
        int[] bit = new int[n + 2];
        int[] mask = new int[n];
        
        for (int i = 0; i < n; i++) {
            mask[i] = 1 << (s.charAt(i) - 'a');
            int l = inTime[i], r = outTime[i];
            for (int j = l; j < bit.length; j += j & -j) bit[j] ^= mask[i];
            for (int j = r + 1; j < bit.length; j += j & -j) bit[j] ^= mask[i];
        }
        
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int u = 0, pos = 7;
                while (pos < q.length() && q.charAt(pos) != ' ') {
                    u = u * 10 + (q.charAt(pos) - '0');
                    pos++;
                }
                pos++;
                char c = q.charAt(pos);
                int newMask = 1 << (c - 'a');
                int diff = mask[u] ^ newMask;
                mask[u] = newMask;
                int l = inTime[u], r = outTime[u];
                for (int j = l; j < bit.length; j += j & -j) bit[j] ^= diff;
                for (int j = r + 1; j < bit.length; j += j & -j) bit[j] ^= diff;
            } else {
                int u = 0, v = 0, pos = 6;
                while (pos < q.length() && q.charAt(pos) != ' ') {
                    u = u * 10 + (q.charAt(pos) - '0');
                    pos++;
                }
                pos++;
                while (pos < q.length() && q.charAt(pos) != ' ') {
                    v = v * 10 + (q.charAt(pos) - '0');
                    pos++;
                }
                
                int lu = u, lv = v;
                if (depth[lu] < depth[lv]) {
                    int temp = lu; lu = lv; lv = temp;
                }
                int diffDepth = depth[lu] - depth[lv];
                for (int i = 0; i < 17; i++) {
                    if (((diffDepth >> i) & 1) == 1) lu = up[lu][i];
                }
                int lca = lu;
                if (lu != lv) {
                    for (int i = 16; i >= 0; i--) {
                        if (up[lu][i] != up[lv][i]) {
                            lu = up[lu][i];
                            lv = up[lv][i];
                        }
                    }
                    lca = up[lu][0];
                }
                
                int qU = 0;
                for (int j = inTime[u]; j > 0; j -= j & -j) qU ^= bit[j];
                int qV = 0;
                for (int j = inTime[v]; j > 0; j -= j & -j) qV ^= bit[j];
                
                int pathMask = qU ^ qV ^ mask[lca];
                ans.add(pathMask == 0 || (pathMask & (pathMask - 1)) == 0);
            }
        }
        
        return ans;
    }
}