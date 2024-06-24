// Problem link: https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int curr = 0, result = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i - k >= 0 && nums[i - k] == 2) 
                curr -= 1;
            
            if((nums[i] + curr) % 2 == 0) {
                if(i + k > nums.length) 
                    return -1;
                
                result++;
                curr += 1;
                nums[i] = 2;
            } 
        }
        return result;
    }
}
