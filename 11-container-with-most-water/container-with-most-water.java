class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0; // global variable
        int l = 0 , r = height.length-1;
       while(l<r){
              int ht = Math.min(height[l] , height[r]);
                int width = r-l;
                int water = ht*width;
                maxWater = Math.max(maxWater , water);
                if(height[l]>height[r]) r--;
                else l++;
           }
         return maxWater;

        
    }
}