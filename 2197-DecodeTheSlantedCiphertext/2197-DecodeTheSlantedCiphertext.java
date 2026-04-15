// Last updated: 4/15/2026, 3:41:47 PM
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols; ++i) {
            for (int r = 0, c = i; r < rows && c < cols; ++r, ++c) {
                res.append(encodedText.charAt(r * cols + c));
            }
        }
        int end = res.length() - 1;
        while (end >= 0 && res.charAt(end) == ' ') {
            end--;
        }
        return res.substring(0, end + 1);
        
    }
}