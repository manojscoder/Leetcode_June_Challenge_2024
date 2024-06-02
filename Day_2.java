// Problem link: https://leetcode.com/problems/reverse-string/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            char c = s[left];
            s[left++] = s[right];
            s[right--] = c;
        }
    }
}
