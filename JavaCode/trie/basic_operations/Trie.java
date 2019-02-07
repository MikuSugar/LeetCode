package JavaCode.trie.basic_operations;

public class Trie {

    class Node
    {
        Node[] child=new Node[26];
        String val="";
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p=root;
        for(char c:word.toCharArray())
        {
            if(p.child[c-'a']==null)
            {
                p.child[c-'a']=new Node();
            }
            p=p.child[c-'a'];
        }
        p.val=word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p=root;
        for(char c:word.toCharArray())
        {
            if(p.child[c-'a']==null) return false;
            p=p.child[c-'a'];
        }
        if(word.equals(p.val))return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p=root;
        for (char c:prefix.toCharArray())
        {
            if(p.child[c-'a']==null) return false;
            p=p.child[c-'a'];
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/trie/166/basic-operations/645/
 * 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
