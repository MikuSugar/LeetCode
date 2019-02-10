package JavaCode.trie.practical_application_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list=new ArrayList<>();
        TreeNode root=new TreeNode();
        for (int i=0;i<words.length;i++)
        {
            addTreeNode(words[i],i,root);
        }
        for(int i=0;i<words.length;i++)
        {
            search(words[i],i,root,list);
        }
        return list;
    }

    class TreeNode
    {
        TreeNode[] child;
        int index;
        List<Integer> list;
        public TreeNode()
        {
            list=new ArrayList<>();
            child=new TreeNode[26];
            index=-1;
        }

    }
    void addTreeNode(String word,int index,TreeNode root)
    {
        for(int i=word.length()-1;i>=0;i--)
        {
            if(root.child[word.charAt(i)-'a']==null)
            {
                root.child[word.charAt(i)-'a']=new TreeNode();
            }
            if(isPalindrome(word,0,i))
            {
                root.list.add(index);
            }
            root=root.child[word.charAt(i)-'a'];
        }
        root.list.add(index);
        root.index=index;
    }

    void search(String word,int index,TreeNode root,List<List<Integer>> list)
    {
        for(int i=0;i<word.length();i++)
        {
            if(root.index>=0&&root.index!=index&&isPalindrome(word,i,word.length()-1))
            {
                list.add(Arrays.asList(index,root.index));
            }
            root=root.child[word.charAt(i)-'a'];
            if(root==null) return;
        }

        for(int i:root.list)
        {
            if(index!=i)
            {
                list.add(Arrays.asList(index,i));
            }
        }

    }

    /**
     * 判断 word 中部分是否为回文
     * @param word
     * @param i 开始索引
     * @param j 结束索引
     * @return
     */
    boolean isPalindrome(String word,int i,int j)
    {
        while (i<j)
        {
            if(word.charAt(i++)!=word.charAt(j--))
            {
                return false;
            }
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/trie/168/practical-application-ii/654/
 * 回文对
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 *
 * 示例 1:
 *
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 *
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 */
