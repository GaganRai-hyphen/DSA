// Last updated: 4/15/2026, 3:43:30 PM
class Solution {
    HashMap<String , List<Character>> hmap;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        hmap = new HashMap<>();
        for(int i = 0 ; i<allowed.size() ; i++){
            String str = allowed.get(i);
            String key = str.substring(0,2);
            if(!hmap.containsKey(key)) hmap.put(key , new ArrayList<>());
            hmap.get(key).add(str.charAt(2));
        }
        return helper(bottom , "" , 0);
    }
    boolean helper(String row , String next , int index){
        if(row.length() == 1 ) return true ;
        if(next.length() == row.length()-1) return helper(next , "" , 0);

        String key = row.substring(index , index+2);
        if(!hmap.containsKey(key)) return false;

        for(char ch : hmap.get(key)){
            if(helper(row , next+ch , index+1 )) return true;
        } 
        return false;
    }
}