package JavaCode.trie.practical_application_i;

import java.util.List;

public class ReplaceWords {
    private Node root;

    public String replaceWords(List<String> dict, String sentence) {
        this.root=new Node();
        for(String s:dict)
        {
            insert(s);
        }

        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++)
        {
            Node p=root;
            for(char c:words[i].toCharArray())
            {
                if(p.child[c-'a']==null)
                {
                    break;
                }
                if(p.child[c-'a'].isWord)
                {
                    words[i]=p.child[c-'a'].val;
                    break;
                }
                p=p.child[c-'a'];
            }
        }

        if(words.length==0) return "";
        if(words.length==1) return words[0];

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length-1;i++)
        {
            sb.append(words[i]+" ");
        }
        sb.append(words[words.length-1]);
        return sb.toString();

    }

    class Node
    {
        boolean isWord;
        Node[] child=new Node[26];
        String val;
        public Node()
        {
            isWord=false;
            val="";
        }
    }

    void insert(String word)
    {
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
        p.val=word;
    }

}
/**
 * https://leetcode-cn.com/explore/learn/card/trie/167/practical-application-i/648/
 * 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 * 示例 1:
 *
 * 输入: dict(词典) = ["cat", "bat", "rat"]
 * sentence(句子) = "the cattle was rattled by the battery"
 * 输出: "the cat was rat by the bat"
 * 注:
 *
 * 输入只包含小写字母。
 * 1 <= 字典单词数 <=1000
 * 1 <=  句中词语数 <= 1000
 * 1 <= 词根长度 <= 100
 * 1 <= 句中词语长度 <= 1000
 */
