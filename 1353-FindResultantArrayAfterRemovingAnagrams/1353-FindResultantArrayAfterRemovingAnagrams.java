// Last updated: 4/15/2026, 3:42:43 PM
class Solution {
   public static  boolean isAna(String s1 ,String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);

        return (Arrays.equals(str1 , str2));
    }
    public List<String> removeAnagrams(String[] words) {
        String prev = "";
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < words.length ; i++){
            if(!isAna(words[i] , prev)){
            list.add(words[i]);
        }
        prev = words[i];
        }
    return list;
    }
   
}