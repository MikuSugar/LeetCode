package JavaCode.random_records.N501_600;

public class N567_permutation_in_string {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())return false;

        int[] book=new int[26];
        for (int i=0;i<s1.length();i++)
        {
            book[s1.charAt(i)-'a']++;
        }

        int[] book1=new int[26];
        for (int i=0;i<s1.length();i++)
        {
            book1[s2.charAt(i)-'a']++;
        }
        if(check(book,book1))return true;

        int left=0,right=s1.length();
        while (right<s2.length())
        {
            book1[s2.charAt(left++)-'a']--;
            book1[s2.charAt(right++)-'a']++;
            if(check(book,book1))return true;
        }

        return false;
    }

    private boolean check(int[] book, int[] book1) {
        for (int i=0;i<26;i++)
        {
            if(book[i]!=book1[i])return false;
        }
        return true;
    }
}
/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
