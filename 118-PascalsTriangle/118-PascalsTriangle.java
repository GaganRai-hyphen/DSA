// Last updated: 4/15/2026, 3:44:11 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int n = 0; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            long x = 1; 

            for (int r = 0; r <= n; r++) {
                row.add((int) x);
            
                x = x * (n - r) / (r + 1);
            }
            result.add(row);
        }
        
        return result;
    }
}