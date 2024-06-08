// Problem link: https://leetcode.com/problems/continuous-subarray-sum/description
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> track = new HashMap<>();
        track.put(0, -1);
        int total_sum = 0;

        for(int i = 0; i < nums.length; i++) {
            total_sum += nums[i];
            if(!track.containsKey(total_sum % k)) {
                track.put(total_sum % k, i);
            }
            else if(i - track.get(total_sum % k) > 1) {
                return true;
            }

        }

        return false;
    }
}
