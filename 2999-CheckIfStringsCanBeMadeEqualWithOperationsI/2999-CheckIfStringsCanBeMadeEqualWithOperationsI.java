// Last updated: 4/15/2026, 3:41:09 PM
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] arr = s1.toCharArray();
        
        if (String.valueOf(arr).equals(s2)) return true;

        swap(arr, 0, 2);
        if (String.valueOf(arr).equals(s2)) return true;

        swap(arr, 1, 3);
        if (String.valueOf(arr).equals(s2)) return true;

        swap(arr, 0, 2); 
        if (String.valueOf(arr).equals(s2)) return true;
        
        return false;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}