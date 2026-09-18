class Solution {
    public List<String> maxNumOfSubstrings(String s) {
       int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        
        List<String> res = new ArrayList<>();
        int right = -1;
        
        for (int i = 0; i < n; i++) {
            if (i == first[s.charAt(i) - 'a']) {
                int newRight = check(s, i, first, last);
                if (newRight != -1) {
                    if (i > right) {
                        res.add(s.substring(i, newRight + 1));
                    } else {
                        res.set(res.size() - 1, s.substring(i, newRight + 1));
                    }
                    right = newRight;
                }
            }
        }
        
        return res;
    }
    
    private int check(String s, int i, int[] first, int[] last) {
        int r = last[s.charAt(i) - 'a'];
        for (int j = i; j <= r; j++) {
            if (first[s.charAt(j) - 'a'] < i) {
                return -1;
            }
            r = Math.max(r, last[s.charAt(j) - 'a']);
        }
        return r;
    }
}