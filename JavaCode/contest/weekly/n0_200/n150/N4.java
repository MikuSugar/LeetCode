package JavaCode.contest.weekly.n0_200.n150;

import java.util.*;

public class N4 {
    public String lastSubstring(String s) {
        List<Integer> idxs=new ArrayList<>();
        char max='a';
        char[] strs = s.toCharArray();
        for (int i=0;i<strs.length;i++)
        {
            if(strs[i]>max)
            {
                max=strs[i];
                idxs.clear();
                idxs.add(i);
            }
            else if(strs[i]==max)
            {
                idxs.add(i);
            }
        }
        if(idxs.size()==s.length())return s;
        int len = 0;
        while (idxs.size() > 1) {
            len++;
            List<Integer> newidxs = new ArrayList<Integer>();
            max = 'a';
            for (int i : idxs) {
                if (i + len >= strs.length) continue;
                if (strs[i + len] > max)
                {
                    max = strs[i + len];
                    newidxs.clear();
                    newidxs.add(i);
                }
                else if (strs[i + len] == max)
                {
                        newidxs.add(i);
                }
            }
            idxs = newidxs;
        }
        return s.substring(idxs.get(0));
    }
}
/**
 *给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："tcode"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 仅含有小写英文字符。
 */
