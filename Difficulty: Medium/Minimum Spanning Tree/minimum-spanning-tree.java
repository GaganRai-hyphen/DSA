class Solution {
    class Edge implements Comparable<Edge> {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
        
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }
    @SuppressWarnings("unchecked")
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<Edge>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            // Since it's an undirected graph for MST
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        int minCost = 0;
        boolean[] isVisited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        // Start with node 0 (weight 0 because it's the starting point)
        pq.add(new Edge(0, 0));
        
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            
            if (isVisited[curr.dest]) continue; // Skip if already in MST
            
            isVisited[curr.dest] = true;
            minCost += curr.weight;
            
            // Add all neighbors of the current node to the PQ
            for (Edge neighbor : adj[curr.dest]) {
                if (!isVisited[neighbor.dest]) {
                    pq.add(new Edge(neighbor.dest, neighbor.weight));
                }
            }
        }
        return minCost;
        
    }
}
