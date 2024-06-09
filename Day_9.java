// Problem link: https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
// Time: O(n)
// Space: O(k)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainder = new int[k];
        int res = 0, total_sum = 0, mod;
        remainder[0] = 1;

        for(int n : nums) {
            total_sum += n;
            mod = (total_sum % k + k) % k;
            if(remainder[mod] != 0) {
                res += remainder[mod];
            }
            remainder[mod] += 1;
        }

        return res;
    }
}
