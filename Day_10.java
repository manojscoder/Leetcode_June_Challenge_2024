// Problem link: https://leetcode.com/problems/height-checker/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        int[] expected = new int[heights.length];
        int res = 0, idx = 0;

        for(int n : heights) {
            count[n] += 1;
        }

        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < count[i]; j++) {
                expected[idx++] = i;
            }
        }

        for(int i = 0; i < heights.length; i++) {
            if(expected[i] != heights[i]) {
                res++;
            }
        }

        return res;
    }
}
