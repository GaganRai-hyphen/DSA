class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int distance = 0;
        int spaces = 0;
        
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                distance--;
            } else if (c == 'R') {
                distance++;
            } else {
                spaces++;
            }
        }
        
        return Math.abs(distance) + spaces;
    }
}