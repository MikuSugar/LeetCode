package JavaCode.contest.n175;

/**
 * author:fangjie
 * time:2020/2/10
 */
public class N2_minimum_number_of_steps_to_make_two_strings_anagram {
    public int minSteps(String s, String t) {
        int[] book1=getCnt(s);
        int[] book2=getCnt(t);
        int res=0;
        for (int i=0;i<26;i++)
        {
            res+=Math.abs(book1[i]-book2[i]);
        }
        return res/2;
    }

    private int[] getCnt(String s) {
        int[] res=new int[26];
        for (char c:s.toCharArray())
        {
            res[c-'a']++;
        }
        return res;
    }
}
/*
给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。

返回使 t 成为 s 的字母异位词的最小步骤数。

字母异位词 指字母相同，但排列不同的字符串。

 

示例 1：

输出：s = "bab", t = "aba"
输出：1
提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
示例 2：

输出：s = "leetcode", t = "practice"
输出：5
提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
示例 3：

输出：s = "anagram", t = "mangaar"
输出：0
提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
示例 4：

输出：s = "xxyyzz", t = "xxyyzz"
输出：0
示例 5：

输出：s = "friend", t = "family"
输出：4
 

提示：

1 <= s.length <= 50000
s.length == t.length
s 和 t 只包含小写英文字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
