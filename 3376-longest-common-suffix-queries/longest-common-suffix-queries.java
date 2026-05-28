class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int minIndex = Integer.MAX_VALUE;
        int minLength = Integer.MAX_VALUE;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        int globalMinIndex = 0;

        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[globalMinIndex].length()) {
                globalMinIndex = i;
            }
            
            String word = wordsContainer[i];
            int len = word.length();
            TrieNode current = root;

            for (int j = len - 1; j >= 0; j--) {
                int charIdx = word.charAt(j) - 'a';
                if (current.children[charIdx] == null) {
                    current.children[charIdx] = new TrieNode();
                }
                current = current.children[charIdx];

                if (len < current.minLength) {
                    current.minLength = len;
                    current.minIndex = i;
                } else if (len == current.minLength) {
                    current.minIndex = Math.min(current.minIndex, i);
                }
            }
        }

        int[] result = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode current = root;
            int bestIndex = globalMinIndex;

            for (int j = query.length() - 1; j >= 0; j--) {
                int charIdx = query.charAt(j) - 'a';
                if (current.children[charIdx] == null) {
                    break;
                }
                current = current.children[charIdx];
                bestIndex = current.minIndex;
            }

            result[i] = bestIndex;
        }

        return result;
    }
}