class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        char[] ans = new char[n + m - 1];
        Arrays.fill(ans, '?');
        boolean[] fixed = new boolean[n + m - 1];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != '?' && ans[i + j] != str2.charAt(j)) {
                        return "";
                    }
                    ans[i + j] = str2.charAt(j);
                    fixed[i + j] = true;
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == '?') {
                ans[i] = 'a';
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (ans[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;
                    for (int j = m - 1; j >= 0; j--) {
                        if (!fixed[i + j]) {
                            ans[i + j] = 'b';
                            changed = true;
                            break;
                        }
                    }
                    if (!changed) {
                        return "";
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean match = true;
            for (int j = 0; j < m; j++) {
                if (ans[i + j] != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (str1.charAt(i) == 'T' && !match) {
                return "";
            }
            if (str1.charAt(i) == 'F' && match) {
                return "";
            }
        }

        return new String(ans);
    }
}