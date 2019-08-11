package JavaCode.contest.n149;

import java.util.ArrayList;
import java.util.List;

public class N3 {
    public int maxRepOpt1(String text) {
        char[] s = text.toCharArray();
        int[] book=new int[s.length];
        int[] cnt=new int[26];
        int start=0;
        int count=0;
        List<Integer> idxs=new ArrayList<>();
        for (int i=0;i<s.length;i++)
        {
            cnt[s[i]-'a']++;
            if(i==0)
            {
                count++;
            }
            else
            {
                if(s[i]==s[i-1])
                {
                    count++;
                }
                else
                {
                    idxs.add(i-1);
                    for (int k=start;k<i;k++)
                    {
                        book[k]=count;
                    }
                    start=i;
                    count=1;
                }
            }
        }
        idxs.add(s.length-1);
        for (int k=start;k<s.length;k++)
        {
            book[k]=count;
        }
        int res=0;
        for (int idx:idxs)
        {
            int sum=0;
            sum+=book[idx];
            if(idx+2<s.length&&s[idx]==s[idx+2])
            {
                sum+=book[idx+2];
            }
            if(sum<cnt[s[idx]-'a'])
            {
                sum++;
            }
            res=Math.max(sum,res);
        }
        return res;
    }
}
/**
 *如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 *
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 *
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 *
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 *
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 *
 * 输入：text = "abcdef"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 */
