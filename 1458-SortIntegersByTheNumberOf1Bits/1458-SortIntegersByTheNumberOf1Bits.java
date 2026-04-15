// Last updated: 4/15/2026, 3:42:38 PM
class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArray = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArray[i] = arr[i];
        }

        Arrays.sort(boxedArray, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            return countA == countB ? a - b : countA - countB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArray[i];
        }

        return arr;
        
    }
}