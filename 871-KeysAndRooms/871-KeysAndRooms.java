// Last updated: 4/15/2026, 3:43:10 PM
class Solution {
       void solve(List<List<Integer>> rooms , int a , boolean isvis[]){
        isvis[a] = true;
        for(int i : rooms.get(a)){
         if(!isvis[i]) solve(rooms , i , isvis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isvis = new boolean[rooms.size()];
        solve(rooms , 0 , isvis);
        for(boolean b : isvis){
            if(!b) return false ;
        }
        return true;
    }
}