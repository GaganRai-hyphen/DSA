// Last updated: 4/15/2026, 3:43:51 PM
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Integer candi1 = null, candi2 = null;
        int vote1 = 0, vote2 = 0;

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (candi1 != null && num == candi1) vote1++;
            else if (candi2 != null && num == candi2) vote2++;
            else if (vote1 == 0) { candi1 = num; vote1 = 1; }
            else if (vote2 == 0) { candi2 = num; vote2 = 1; }
            else { vote1--; vote2--; }
        }

        // Step 2: Verify candidates
        List<Integer> result = new ArrayList<>();
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (candi1 != null && num == candi1) count1++;
            if (candi2 != null && num == candi2) count2++;
        }

        if (count1 > n / 3) result.add(candi1);
        if (count2 > n / 3) result.add(candi2);

        return result;
    }
}
