// Problem link: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int appendCharacters(String s, String t) {
        int index = 0, t_length = t.length();

        for(char c : s.toCharArray()) {
            if(index < t_length && t.charAt(index) == c) {
                index++;
            }
        }

        return t_length - index;
    }
}
