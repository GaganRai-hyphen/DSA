// Last updated: 4/15/2026, 3:41:51 PM
class Solution {
    public int countValidWords(String sentence) {
        String []words=sentence.trim().split("\\s+");
        int count=0;
        for(String word:words){
            if(hyphenCheck(word)&&digitCheck(word)&&puchuationCheck(word))count++;
        }
        return count;
    }
     public static boolean hyphenCheck(String s){
        int hypenCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='-'){
                hypenCount++;
                if(hypenCount>1)return false;
                if(i==0||i==s.length()-1)return false;
              
                if(!Character.isLowerCase(s.charAt(i-1))||!Character.isLowerCase(s.charAt(i+1)))return false;
            }
        }
        return true;
    }
    public static boolean digitCheck(String s){
        for(char c:s.toCharArray())if(c>='0'&& c<='9')return false;
        return true;
    }
    public static boolean puchuationCheck(String s){
         for(int i=0;i<s.length()-1;i++)if(s.charAt(i)=='.'||s.charAt(i)=='!'||s.charAt(i)==',')return false;
        return true;
    }
}