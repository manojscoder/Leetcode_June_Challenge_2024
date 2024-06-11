// Problem link: https://leetcode.com/problems/relative-sort-array/description
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = arr1.length - 1, n = arr1.length ;
        int[] result = new int[n];

        for(int i : arr2)   
            set.add(i);

        for(int i : arr1)
            if(!set.contains(i))
                result[right--] = i;
            else
                map.put(i, map.getOrDefault(i, 0) + 1);

        Arrays.sort(result, right, n);

        for(int i : arr2)
            for(int j = 0; j < map.get(i); j++)
                result[left++] = i;

        return result;
    }
}
