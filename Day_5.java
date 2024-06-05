// Problem link: https://leetcode.com/problems/find-common-characters/description
// Time: O(n * m), where n is the length of the words array, and m is average length of all words in words array
// Space: O(1)
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] temp, store = new int[26];

        for(char c : words[0].toCharArray()) {
            store[c - 'a']++;
        }

        for(int i = 1; i < words.length; i++) {
            temp = new int[26];

            for(char c : words[i].toCharArray()) {
                temp[c - 'a']++;
            }

            for(int j = 0; j < 26; j++) {
                store[j] = Math.min(store[j], temp[j]);
            }
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < store[i]; j++) {
                result.add((char)((int)'a' + i) + "");
            }
        }

        return result;
    }
}
