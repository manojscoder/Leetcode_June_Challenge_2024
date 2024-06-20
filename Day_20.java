// Problem link: https://leetcode.com/problems/magnetic-force-between-two-balls/description
// Time: O(n log n)
// Space: O(n) for sorting
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length, result = -1;
        int left = 0, right = position[n - 1], mid;

        while(left <= right) {
            mid = (left + right) / 2;

            if(isPossible(mid, position, m)) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean isPossible(int diff, int[] position, int m) {
        int count = 1, prev = 0;

        for(int i = 0; i < position.length; i++) {
            if(position[i] - position[prev] >= diff) {
                count++;
                prev = i;
            }
        }
        
        return count >= m;
    }
}
