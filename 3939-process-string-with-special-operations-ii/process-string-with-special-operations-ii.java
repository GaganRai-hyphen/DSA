class Solution {
    public char processStr(String s, long k) {
        long m = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                m = Math.max(0L, m - 1);
            } else if (c == '#') {
                m <<= 1;
            } else if (c != '%') {
                m++;
            }
        }
        
        if (k >= m) {
            return '.';
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                m++;
            } else if (c == '#') {
                m /= 2;
                if (k >= m) {
                    k -= m;
                }
            } else if (c == '%') {
                k = m - 1 - k;
            } else {
                m--;
                if (k == m) {
                    return c;
                }
            }
        }
        
        return '.';
    }
}