package Page5;

/*
* Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
* */
public class N208_ImplementTrie {
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "hello";
        obj.insert(word);
        System.out.println(obj.search("hello"));
        System.out.println(obj.search("he"));
        System.out.println(obj.startsWith("he"));
        System.out.println(obj.startsWith("hello"));
    }
}

class TrieNode {
    public char val = ' ';
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord = false;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.val = c;
    }
}

class Trie {

    private TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.children[c - 'a'] == null) {
                t.children[c - 'a'] = new TrieNode(c);
            }
            t = t.children[c - 'a'];
        }
        t.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.children[c - 'a'] == null) {
                return false;
            }
            t = t.children[c - 'a'];
        }
        return t.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (t.children[c - 'a'] == null) {
                return false;
            }
            t = t.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
