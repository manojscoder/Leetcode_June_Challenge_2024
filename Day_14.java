// Problem link: https://leetcode.com/problems/minimum-increment-to-make-array-unique/description
// Time: O(nlogn)
// Space: O(n) for sorting
class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] >= nums[i]) {
                res += 1 + (nums[i - 1] - nums[i]);
                nums[i] = 1 + nums[i - 1];
            }
        }

        return res;
    }
}
