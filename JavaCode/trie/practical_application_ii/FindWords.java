package JavaCode.trie.practical_application_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {

    public static void main(String[] args) {
        char[][] b={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] s={"oath","pea","eat","rain"};
        for(String s1:new FindWords().findWords(b,s))
        {
            System.out.println(s1);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root=new Node();
        for(String s:words)
        {
            root=add(root,s);
        }

        boolean[][] book=new boolean[board.length][board[0].length];
        Set<String> set=new HashSet<>();
        for (int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                find(board,i,j,book,set,root);
            }
        }
        List<String> result=new ArrayList<>();
        result.addAll(set);
        return result;
    }

    private int[] row={-1,1,0,0};
    private int[] col={0,0,-1,1};

    void find(char[][] board,int i,int j,boolean[][] book,Set<String> set,Node root)
    {
        Node p=root.child[board[i][j]-'a'];
        if(p==null) return;
        book[i][j]=true;
        if(p.word!=null) set.add(p.word);

        for(int k=0;k<4;k++)
        {
            int ii=i+row[k];
            int jj=j+col[k];
            if(ii>=0&&ii<board.length&&jj>=0&&jj<board[0].length&&!book[ii][jj])
            {
                if(p.child[board[ii][jj]-'a']!=null)
                {
                    find(board, ii, jj, book, set, p);
                }
            }
        }
        book[i][j]=false;
    }

    class Node
    {
        String word;
        Node[] child;
        public Node()
        {
            child=new Node[26];
        }

    }

    Node add(Node root,String word)
    {
        Node p=root;
        for(char c:word.toCharArray())
        {
            if (p.child[c-'a']==null)
            {
                p.child[c-'a']=new Node();
            }
            p=p.child[c-'a'];
        }
        p.word=word;
        return root;
    }

}
/**
 * https://leetcode-cn.com/explore/learn/card/trie/168/practical-application-ii/652/
 * 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */
