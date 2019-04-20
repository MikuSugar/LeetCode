package JavaCode.random_records.N301_400;


public class N395_longest_substring_with_at_least_k_repeating_characters {

    public int longestSubstring(String s, int k) {
        if(s==null||s.length()==0)return 0;
        int[] book=new int[26];
        for (int i=0;i<s.length();i++)
        {
            book[s.charAt(i)-'a']++;
        }

        int res=0;
        boolean flag=false;
        for (int i:book)
        {
            if(i>0&&i<k)
            {
                flag=true;
                break;
            }
        }
        if(flag)
        {
            StringBuilder reg=new StringBuilder();
            for (int i=0;i<26;i++)
            {
                if(book[i]>0&&book[i]<k)
                    reg.append((char)('a'+i)+"|");
            }
            reg.deleteCharAt(reg.length()-1);
            System.out.println(reg.toString());
            String[] strs=s.split(reg.toString());
            for (String s1:strs)
            {
                res=Math.max(res,longestSubstring(s1,k));
            }
        }
        else res=s.length();
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 */
