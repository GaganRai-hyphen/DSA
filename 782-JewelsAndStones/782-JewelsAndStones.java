// Last updated: 4/15/2026, 3:43:18 PM
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> list = new HashSet<>();
        int ans = 0;
        for(char j : jewels.toCharArray()){
          list.add(j);
        }
        for(char s : stones.toCharArray()){
            if(list.contains(s)){
                ans++;
            }
        }
      return ans;
    }
}