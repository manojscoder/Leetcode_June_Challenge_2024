// Problem link: https://leetcode.com/problems/patching-array/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int minPatches(int[] nums, int n) {
        int result = 0, idx = 0;
        long max_number = 0;

        while(max_number < n) {
            if(idx < nums.length && max_number + 1 >= nums[idx]) {
                max_number += nums[idx];
                idx++;
            }
            else {
                result++;
                max_number += (max_number + 1);
            }
        }

        return result;
    }
}
