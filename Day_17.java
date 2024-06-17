// Problem link: https://leetcode.com/problems/sum-of-square-numbers/description
// Time: O(sqrt(c))
// Space: O(1)
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long)Math.sqrt(c) + 1, total;

        while(left <= right) {
            total = left * left + right * right;
            if(total == c)
                return true;
            else if(total > c)
                right--;
            else
                left++;
        }

        return false;
    }
}
