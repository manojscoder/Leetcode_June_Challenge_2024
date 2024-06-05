// Problem link: https://leetcode.com/problems/find-common-characters/description
// Time: O(n)
// Space: O(n)
class Solution {
    public List<String> commonChars(String[] words) {
        char[][] store = new char[words.length][26];
        List<String> result = new ArrayList<>();
        char chr;
        int val;

        for(int i = 0; i < words.length; i++) {
            for(char c: words[i].toCharArray()) {
                store[i][c - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++) {
            chr = (char)((int)'a' + i);
            val = Integer.MAX_VALUE;

            for(int j = 0; j < words.length; j++) {
                val = Math.min(val, store[j][chr - 'a']);
            }

            for(int j = 0; j < val; j++) {
                result.add(chr + "");
            }
        }

        return result;

    }
}
