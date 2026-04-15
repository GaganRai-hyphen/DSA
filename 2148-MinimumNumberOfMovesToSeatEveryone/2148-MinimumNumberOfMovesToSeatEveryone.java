// Last updated: 4/15/2026, 3:41:53 PM
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for(int i = 0 ; i<seats.length ; i++){
       sum += Math.abs(seats[i]-students[i]);
        }
        return sum;
    }
}