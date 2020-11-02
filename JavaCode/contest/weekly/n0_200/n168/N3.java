package JavaCode.contest.weekly.n0_200.n168;

import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/12/22
 */
public class N3 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] strs=s.toCharArray();
        int[] book=new int[26];
        int left=0,right=0;
        int res=0;
        Map<String,Integer> map=new HashMap<>();
        while (right<strs.length)
        {
            book[strs[right++]-'a']++;
            int cnt=getCnt(book);
            while (getCnt(book)>maxLetters)
            {
                book[strs[left++]-'a']--;
            }
            while ((right-left)>maxSize)
            {
                book[strs[left++]-'a']--;
            }
            for (int i=left;i<right&&(right-i)>=minSize;i++)
            {
                String cur=s.substring(i,right);
                int c=map.getOrDefault(cur,0)+1;
                map.put(cur,c);
                res=Math.max(res,c);
            }
        }
        return res;
    }
    private int getCnt(int[] book)
    {
        int res=0;
        for (int i:book)
        {
            res+=i>0?1:0;
        }
        return res;
    }
}
/*
给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：

子串中不同字母的数目必须小于等于 maxLetters 。
子串的长度必须大于等于 minSize 且小于等于 maxSize 。


示例 1：

输入：s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
输出：2
解释：子串 "aab" 在原字符串中出现了 2 次。
它满足所有的要求：2 个不同的字母，长度为 3 （在 minSize 和 maxSize 范围内）。
示例 2：

输入：s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
输出：2
解释：子串 "aaa" 在原字符串中出现了 2 次，且它们有重叠部分。
示例 3：

输入：s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
输出：3
示例 4：

输入：s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
输出：0


提示：

1 <= s.length <= 10^5
1 <= maxLetters <= 26
1 <= minSize <= maxSize <= min(26, s.length)
s 只包含小写英文字母。
 */
