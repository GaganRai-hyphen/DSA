// Last updated: 4/15/2026, 3:41:32 PM
class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for(int i = 0; i<num.length()-2 ; i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
            String temp = num.substring(i,i+3);
            if(temp.compareTo(max)>0){
                max = temp;
            }
            }
        }
        return max;
        
    }
}