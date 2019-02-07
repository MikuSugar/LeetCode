package JavaCode.trie.practical_application_i;

public class WordDictionary {

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node p=root;
        for(char c:word.toCharArray())
        {
            if(p.child[c-'a']==null)
            {
                p.child[c-'a']=new Node();
            }
            p=p.child[c-'a'];
        }
        p.isWord=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root,0,word.toCharArray());
    }

    /**
     *
     * @param node 开始寻找的节点
     * @param index 开始寻找的位置
     * @param word 寻找的词
     * @return
     */
    private boolean dfs(Node node,int index,char[] word)
    {
        for(int i=index;i<word.length;i++)
        {
            if(word[i]!='.')
            {
                if(node.child[word[i]-'a']==null)
                {
                    return false;
                }
                node=node.child[word[i]-'a'];
            }
            else
            {
                for(int k=0;k<26;k++)
                {
                    if(node.child[k]!=null)
                    {
                        if(dfs(node.child[k],i+1,word))
                        {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return node.isWord;
    }

    class Node
    {
        boolean isWord;
        Node[] child;
        public Node()
        {
            isWord=false;
            child=new Node[26];
        }

    }
}
/**
 *  添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 */
