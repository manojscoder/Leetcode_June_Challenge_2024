// Problem link: https://leetcode.com/problems/score-of-a-string/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for(int i = 0; i + 1 < s.length(); i++){
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}
