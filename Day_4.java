// Problem link: https://leetcode.com/problems/longest-palindrome/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int longestPalindrome(String s) {
        int[] store = new int[52];
        int result = 0, odd = 0;

        for(char c : s.toCharArray()) {
            if(c - 'A' < 26) {
                store[c - 'A']++;
            }
            else {
                store[c - 'a' + 26]++;
            }
        }

        for(int n : store) {
            if(n % 2 == 1) {
                result -= 1;
                odd = 1;
            }
            result += n;
        }

        return result + odd;
    }
}
