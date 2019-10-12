package JavaCode.random_records.N1_100;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/12
 */
public class N30_substring_with_concatenation_of_all_words {

    // s = "barfoothefoobarman",
    //  words = ["foo","bar"]
    public static void main(String[] args) {
        System.out.println(new N30_substring_with_concatenation_of_all_words().findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length==0)return new ArrayList<>();
        List<Node>[] nodes=new List[s.length()];
        for (int i=0;i<nodes.length;i++)nodes[i]=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        int sum=0;
        for (String word:words)
        {

            map.put(word,map.getOrDefault(word,0)+1);
            sum+=word.length();
            if(map.get(word)==1)setNode(word.toCharArray(),s.toCharArray(),nodes);
        }
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<s.length()-sum+1;i++)
        {
            if(serach(i,0,nodes,map,s.length(),words.length))
            {
                res.add(i);
            }
        }
        return res;
    }

    private boolean serach(int idx, int i, List<Node>[] nodes, Map<String, Integer> map, final int len, final int cnt) {
        if(i==cnt)return true;
        if(idx>=len)return false;
        for (Node node:nodes[idx])
        {
            int  c=map.get(node.val);
            if(c==0)continue;
            map.put(node.val,c-1);
            if(serach(idx+node.val.length(),i+1,nodes,map,len,cnt))
            {
                map.put(node.val,c);
                return true;
            }
            map.put(node.val,c);
        }
        return false;
    }


    private void setNode(char[] word, char[] str, List<Node>[] nodes) {
        for (int i=0;i<str.length;i++)
        {
           if(str[i]==word[0])
           {
               if(check(word,str,i))
               {
                   nodes[i].add(new Node(new String(word),i));
               }
           }
        }
    }

    private boolean check(char[] word, char[] str, int start) {
        for (int i=0;i<word.length;i++)
        {
            int j=start+i;
            if(j==str.length)return false;
            if(str[j]!=word[i])return false;
        }
        return true;
    }


    class Node
    {
        String val;
        int start;
        public Node(String val, int start) {
            this.val=val;
            this.start=start;
        }
    }
}
/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
