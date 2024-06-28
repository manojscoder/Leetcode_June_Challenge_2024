// Problem link: https://leetcode.com/problems/maximum-total-importance-of-roads/description
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        long result = 0, val = 1;

        for(int i = 0; i < roads.length; i++) {
            degree[roads[i][0]] += 1;
            degree[roads[i][1]] += 1;
        }

        Arrays.sort(degree);

        for(int d : degree) {
            result += (val++ * d);
        }

        return result;
    }
}
