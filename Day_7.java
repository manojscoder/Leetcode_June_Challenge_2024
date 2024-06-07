// Problem link: https://leetcode.com/problems/replace-words/description
// Time: O((N + W) * L), where N is the number of words in dict, W is the number of words in sentence, L is the avg length of words in dict 
// Space: O(N * L + M), where N is the number of words in dict, L is the avg length of words in dict, M is the number of characters in the sentence
class TrieNode {
    TrieNode[] letters;
    int index;
    boolean end;

    public TrieNode() {
        this.letters = new TrieNode[26];
        this.index = -1;
        this.end = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(char[] word, int idx) {
        TrieNode temp = this.root;

        for(char c : word) {
            if(temp.letters[c - 'a'] == null) {
                temp.letters[c - 'a'] = new TrieNode();
            }
            temp = temp.letters[c - 'a'];
        }

        temp.index = idx;
        temp.end = true;
    }

    public int search(char[] word) {
        TrieNode temp = this.root;

        for(char c : word) {
            if(temp.letters[c - 'a'] == null) {
                return -1;
            }
            temp = temp.letters[c - 'a'];
            if(temp.end) {
                return temp.index;
            }
        }

        return -1;
    }
}


class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        int index;

        for(int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i).toCharArray(), i);
        }

        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++) {
            index = trie.search(words[i].toCharArray());
            if(index != -1) {
                words[i] = dictionary.get(index);
            }
        }

        return String.join(" ", words);
    }
}
