// Problem link: https://leetcode.com/problems/sort-colors/description
// Time: O(n)
// Space: O(1)
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, idx = 0, right = nums.length - 1, temp;
        
        while(idx <= right) {
            if(nums[idx] == 0) {
                temp = nums[left];
                nums[left++] = nums[idx];
                nums[idx++] = temp;
            }
            else if(nums[idx] == 2) {
                temp = nums[right];
                nums[right--] = nums[idx];
                nums[idx] = temp;
            }
            else{
                idx++;
            }
        }
    }
}
