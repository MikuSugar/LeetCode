package JavaCode.random_records.N401_500;

import java.util.ArrayList;
import java.util.List;

public class N438_find_all_anagrams_in_a_string {

    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()||s.length()==0)return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int[] book_p=new int[26];
        for (int i=0;i<p.length();i++)
        {
            book_p[p.charAt(i)-'a']++;
        }

        int[] book=new int[26];
        int left=0,right=0;
        book[s.charAt(left)-'a']++;
        while (true)
        {
            int len=right-left+1;
            if(len<p.length())
            {
                right++;
                if(right>=s.length())break;
                book[s.charAt(right)-'a']++;
            }
            else if(len==p.length())
            {
                if(check(book,book_p))res.add(left);
                book[s.charAt(left++)-'a']--;
            }
        }
        return res;
    }

    private boolean check(int[] book, int[] book_p) {
        for (int i=0;i<26;i++)
        {
            if(book[i]!=book_p[i])return false;
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
