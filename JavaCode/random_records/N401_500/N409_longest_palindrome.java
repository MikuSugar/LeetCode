package JavaCode.random_records.N401_500;

public class N409_longest_palindrome {
    public int longestPalindrome(String s) {
        if(s.length()<2)return s.length();

        int[] book_low=new int[26];
        int[] book_up=new int[26];
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isLowerCase(c)) book_low[c-'a']++;
            else book_up[c-'A']++;
        }
        int res=0;
        for (int i=0;i<26;i++)
        {
            if(book_low[i]>0)res+=book_low[i]%2==0?book_low[i]:book_low[i]-1;
            if(book_up[i]>0)res+=book_up[i]%2==0?book_up[i]:book_up[i]-1;
        }
        res+=res<s.length()?1:0;
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
