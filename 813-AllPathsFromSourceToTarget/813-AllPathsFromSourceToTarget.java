// Last updated: 4/15/2026, 3:43:15 PM
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans  = new ArrayList<>();
        List<Integer> list  = new ArrayList<>();
        boolean[] isvis = new boolean[graph.length];
        solve(graph , 0 , graph.length-1 , ans , list , isvis);
        return ans;

    }
    void solve(int[][] graph , int src , int dest ,  List<List<Integer>> ans , List<Integer> list , boolean[] isvis  ){
        list.add(src);
        isvis[src] = true;

        if(src == dest) ans.add(new ArrayList<>(list));

        for(int a : graph[src]){
            if(!isvis[a]) solve(graph , a , dest , ans , list , isvis );
        }
        list.remove(list.size()-1);
        isvis[src] = false;
    }
}