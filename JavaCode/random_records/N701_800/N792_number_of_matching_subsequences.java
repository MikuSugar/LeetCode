package JavaCode.random_records.N701_800;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N792_number_of_matching_subsequences {
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer>[] book=new List[26];
        for (int i=0;i<26;i++)
        {
            book[i]=new ArrayList<>();
        }
        for (int i=0;i<S.length();i++)
        {
            book[S.charAt(i)-'a'].add(i);
        }
        int res=0;
        for (String s:words)
        {
            res+=check(s,book)?1:0;
        }
        return res;
    }

    private boolean check(String s, List<Integer>[] book) {
        int cur=-1;
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            List<Integer> list=book[c-'a'];
            int index=Collections.binarySearch(list,cur);
            index=index<0?-index-1:index+1;
            if(index>=list.size())return false;
            cur=list.get(index);
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/number-of-matching-subsequences/
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 示例:
 * 输入:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 * 注意:
 *
 * 所有在words和 S 里的单词都只由小写字母组成。
 * S 的长度在 [1, 50000]。
 * words 的长度在 [1, 5000]。
 * words[i]的长度在[1, 50]。
 */
