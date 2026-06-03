class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }
        
        int minWaterEnd = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[i] + waterDuration[i]);
        }
        
        int landThenWater = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            int finishTime = Math.max(waterStartTime[i], minLandEnd) + waterDuration[i];
            landThenWater = Math.min(landThenWater, finishTime);
        }
        
        int waterThenLand = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            int finishTime = Math.max(landStartTime[i], minWaterEnd) + landDuration[i];
            waterThenLand = Math.min(waterThenLand, finishTime);
        }
        
        return Math.min(landThenWater, waterThenLand);
    }
}